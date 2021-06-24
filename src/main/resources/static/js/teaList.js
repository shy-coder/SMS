layui.use(['table', 'jquery', 'form', 'upload'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var form = layui.form;
    var upload = layui.upload;
    table.render({
        elem: '#teaData'
        , url: '/teacher/teacherListData'
        , toolbar: '#toolBar' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            , layEvent: 'LAYTABLE_TIPS'
            , icon: 'layui-icon-tips'
        }]
        , title: '教师列表'
        , cols: [
            [
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'ID', fixed: 'left', unresize: true, sort: true}
                , {field: 'tno', title: '工号', edit: 'text'}
                , {field: 'teacher_name', title: '姓名', edit: 'text'}
                , {
                field: 'eamil', title: 'email', edit: 'text', templet: function (res) {
                    return '<em>' + res.email + '</em>'
                }
            }
                , {field: 'gender', title: '性别', edit: 'text'}
                , {field: 'telephone', title: '电话', edit: 'text'}
                , {field: 'address', title: '地址', edit: 'text'}
                , {field: 'portrait_path', title: '头像地址', edit: 'text'}
                , {fixed: 'right', title: '操作', toolbar: '#actBar'}
            ]
        ]
        , page: true
    });
    //头工具栏事件
    table.on('toolbar(teaData)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getAddData':
                $('#teaInfo')[0].reset();
                $('#tno').attr('disabled',false);
                $('#image').attr('src',"images/default.jpg")
                layer.open({
                    type: 1,
                    area: ['50%', '50%'],
                    btn: ['确认', '取消'],
                    yes: function (index) {
                        var teaData = form.val('teaInfo')
                        $.ajax({
                                type: "POST",
                                data: {
                                    'id': teaData.id,
                                    'tno': teaData.tno,
                                    'teacher_name': teaData.teacher_name,
                                    'password': teaData.password,
                                    'gender': teaData.gender,
                                    'email': teaData.email,
                                    'telephone': teaData.telephone,
                                    'address': teaData.address,
                                    'portrait_path': $('#image').attr('src'),
                                },
                                url: '/teacher/insert',
                                error: function (XMLHttpRequest) {
                                    alert("添加失败了!");
                                },
                                success: function (resData) {
                                    if (resData.status === 1) {
                                        alert("添加成功！");
                                        layer.close(index);
                                        location.reload();
                                    } else {
                                        alert("添加失败了！");
                                        alert(resData.msg);
                                    }
                                }
                            }
                        )
                    },
                    content: $('#teaInfo')
                })
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选');
                break;

            //自定义头工具栏右侧图标 - 提示
            case 'LAYTABLE_TIPS':
                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                break;
        }
        ;
    });

    //监听行工具事件
    table.on('tool(teaData)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    type: "POST",
                    data: {
                        'id': data.id
                    },
                    url: '/teacher/delete',
                    error: function (XMLHttpRequest) {
                        alert("删除失败了!");
                        alert(XMLHttpRequest.status);
                    },
                    success: function (resData) {
                        if (resData.status === 1) {
                            obj.del();
                            alert("删除成功");
                        } else {
                            alert("删除失败了！");
                        }
                    }
                })
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            $('#image').attr('src', "" + data.portrait_path)
            form.val('teaInfo', {
                'id': data.id,
                'tno': data.tno,
                'teacher_name': data.teacher_name,
                'gender': data.gender,
                'email': data.email,
                'telephone': data.telephone,
                'address': data.address,
            })
            layer.open({
                type: 1,
                area: ['50%', '50%'],
                btn: ['确认', '取消'],
                yes: function (index) {
                    var teaData = form.val('teaInfo')
                    $.ajax({
                            type: "POST",
                            data: {
                                'id': teaData.id,
                                'tno': teaData.tno,
                                'teacher_name': teaData.teacher_name,
                                'password': teaData.password,
                                'gender': teaData.gender,
                                'email': teaData.email,
                                'telephone': teaData.telephone,
                                'address': teaData.address,
                                'portrait_path': $('#image').attr('src'),
                            },
                            url: '/teacher/upload',
                            error: function (XMLHttpRequest) {
                                alert("更新失败了!");
                                alert(XMLHttpRequest.status);
                            },
                            success: function (resData) {
                                if (resData.status === 1) {
                                    alert("更新成功！");
                                    layer.close(index);
                                    location.reload();
                                } else {
                                    alert("更新失败了！");
                                }
                            }
                        }
                    )
                },
                content: $('#teaInfo')
            })
        }
    });

    //上传头像
    var uploadInst = upload.render({
        elem: '#imgUp'
        , url: '/upload/'
        , accept: 'images'
        , size: 50000
        , before: function (obj) {
            obj.preview(function (index, file, result) {
                $('#image').attr('src', result);
            });
        }
        , done: function (res) {
            //如果上传失败
            if (res.code > 0) {
                return layer.msg('上传失败');
            }
            //上传成功
            var upText = $('#imgText');
            upText.html('<span style="color: #4cae4c;">上传成功</span>');
            var fileupload = $("#image");
            fileupload.attr("src", res.data.src);
            console.log(fileupload.attr("src"));
        }
        , error: function () {
            //演示失败状态，并实现重传
            var demoText = $('#imgText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
    });
});
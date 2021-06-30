layui.use(['form', 'table', 'upload', 'element', 'layer', 'jquery'], function () {
    const $ = layui.jquery
        , upload = layui.upload
        , element = layui.element
        , layer = layui.layer
        , form = layui.form;
    const table = layui.table;
    const url = $("#ctx").val();
    var file;
    var clazz = $('#clazz_id');
    console.log(url.toString());
    console.log("老师id"+userId);
    var url_stu;
    if (role===0) {
        url_stu = '/stu/list?role='+role;
    }else {
        url_stu = '/stu/list?role='+role+'&id='+userId;
    }


    table.render({
        elem: '#test'
        , url: url_stu
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            , layEvent: 'LAYTABLE_TIPS'
            , icon: 'layui-icon-tips'
        }]
        , title: '用户数据表'
        , cols:
            [
                [
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'id', title: 'ID', fixed: 'left', unresize: true, sort: true}
                    , {field: 'sno', title: '学号', edit: 'text'}
                    , {field: 'student_name', title: '姓名', edit: 'text'}
                    , {field: 'gender', title: '性别',  edit: 'text'}
                    , {
                    field: 'email', title: '邮箱',  edit: 'text', templet: function (res) {
                        return '<em>' + res.email + '</em>'
                    }
                }
                    , {field: 'telephone', title: '电话',  edit: 'text'}
                    , {field: 'address', title: '城市'}
                    , {field: 'introduce', title: '介绍' }
                    , {
                    field: 'portrait_path',
                    title: '头像',
                    templet: '<div><img  src="{{ d.portrait_path }}" style="height: 20px;width: 20px"></div>',
                }
                    , {field: 'clazz_id', title: '班级id'}
                    , {field: 'clazz_name', title: '班级名称'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
                ]
            ]
        , page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            //新增学生
            case 'addStudent':
                $('#book')[0].reset();
                $('#demo1').attr('src',"")
                $.ajax({
                    type:'POST',
                    url:'/clazz/findAll',
                    async:false,
                    success:function (resData) {
                        $.each(resData, function (index,value) {
                            console.log(resData);
                            clazz.append(new Option(value.clazz_name,value.id));
                        })
                    }
                })
                layui.form.render('select');
                layer.open({
                    type: 1,
                    title: "新增",
                    area: ['50%', '50%'],
                    btn: ['确定', '取消'],
                    content: $("#window"),
                    yes: function (index) {
                        var stuData = form.val('example')
                        $.ajax(
                            {
                                type: "POST",
                                data:{
                                    sno: $('#sno').val(),
                                    student_name: $('#student_name').val(),
                                    password: $('#password').val(),
                                    gender: $('input[name="gender"]:checked').val(),
                                    email: $('#email').val(),
                                    telephone: $('#telephone').val(),
                                    address: $('#address').val(),
                                    introduce: $('#introduce').val(),
                                    portrait_path: file,
                                    clazz_id:stuData.clazz_id
                                },
                                url:'/stu/add',
                                success:function (data){
                                    //根据后台返回的参数，来进行判断
                                    layer.alert('增加成功',{icon:1,title:'提示'},function(i){
                                        //layer.close(i);
                                        layer.closeAll();//关闭弹出层
                                        $("#book")[0].reset()//重置form
                                    })
                                    table.reload('test',{//重载表格
                                        page:{
                                            curr:1
                                        }
                                    })
                                }
                            }
                        )
                    }
                });
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

    //上传头像
    const uploadInst = upload.render({
        elem: '#test1'
        , url: '/upload' //改成您自己的上传接口
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#demo1').attr('src', result); //图片链接（base64）
            });
            element.progress('demo', '0%'); //进度条复位
            layer.msg('上传中', {icon: 16, time: 0});
        }
        , done: function (res) {
            //如果上传失败
            if (res.code > 0) {
                return layer.msg('上传失败');
            }
            //上传成功的一些操作
            console.log("!!!!!!!!" + res.data.src);
            file = res.data.src;
            $('#demoText').html(''); //置空上传失败的状态
        }
        , error: function () {
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
        //进度条
        , progress: function (n, elem, e) {
            element.progress('demo', n + '%'); //可配合 layui 进度条元素使用
            if (n == 100) {
                layer.msg('上传完毕', {icon: 1});
            }
        }
    });

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        const data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    type: "POST",
                    data: {
                        'id': data.id
                    },
                    url: '/stu/del',
                    success: function (result) {
                        if (result.data > 0) {
                            obj.del();
                            table.reload('test', {
                                page: {
                                    curr: 1
                                }
                            })
                            alert("删除成功");
                        } else {
                            alert("删除失败");
                        }
                    }
                })
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            //填充数据
            $.ajax({
                type:'POST',
                url:'/clazz/findAll',
                async:false,
                success:function (resData) {
                    $.each(resData, function (index,value) {
                        clazz.append(new Option(value.clazz_name,value.id));
                    })
                }
            })
            $('#demo1').attr('src', "" + data.portrait_path)
            form.val('example', {
                'sno': data.sno,
                'student_name': data.student_name,
                'gender': data.gender,
                'email': data.email,
                'telephone': data.telephone,
                'address': data.address,
                'introduce': data.introduce
            })
            clazz.val(data.clazz_id);
            layui.form.render('select');
            //表单提交
            layer.open({
                type: 1,
                title: '修改',
                area: ['50%', '50%'],
                btn: ['确认', '取消'],
                content: $('#window'),
                yes: function (index) {
                    var stuData = form.val('example')
                    $.ajax({
                            type: "POST",
                            data: {
                                'id': data.id,
                                'sno': stuData.sno,
                                'student_name': stuData.student_name,
                                'password': stuData.password,
                                'gender': stuData.gender,
                                'email': stuData.email,
                                'telephone': stuData.telephone,
                                'address': stuData.address,
                                'introduce': stuData.introduce,
                                'portrait_path': file,
                                'clazz_id': stuData.clazz_id,
                            },
                            url: '/stu/update',
                            error: function (XMLHttpRequest) {
                                alert("更新失败了!");
                                alert(XMLHttpRequest.status);
                            },
                            success: function (result) {
                                if (result.data > 0) {
                                    layer.closeAll();
                                    table.reload('test', {
                                        page: {
                                            curr: 1
                                        }
                                    })
                                    alert("更新成功");
                                } else {
                                    alert("更新失败");
                                }
                            }
                        }
                    )
                }
            });
        }
    });
});
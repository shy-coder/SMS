layui.use(['table', 'jquery', 'form'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var form = layui.form;
    var teacher_name = $('#teacher_name');
    table.render({
        elem: '#acadData'
        , url: '/acad/list'
        , toolbar: '#toolBar' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            , layEvent: 'LAYTABLE_TIPS'
            , icon: 'layui-icon-tips'
        }]
        , title: '学院列表'
        , cols: [
            [
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'ID', fixed: 'left', unresize: true, sort: true}
                , {field: 'acad_name', title: '学院名', edit: 'text'}
                , {field: 'teacher_name', title: '学院主任', edit: 'text'}
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
                $('#addAcad')[0].reset();
                $.ajax({
                    type:'POST',
                    url:'/teacher/teacherListData',
                    async:false,
                    success:function (resData) {
                        $.each(resData.data, function (index,value) {
                            teacher_name.append(new Option(value.teacher_name,value.id));
                        })
                    }
                })
                layui.form.render('select');
                layer.open({
                    content: $('#addAcad'),
                    type: 1,
                    area: ['50%', '50%'],
                    btn: ['确认', '取消'],
                    yes: function (index) {
                        var acadData = form.val('addAcad')
                        $.ajax({
                                type: "POST",
                                data: {
                                    'acad_name': acadData.acad_name,
                                    'manager_id': acadData.teacher_name
                                },
                                url: '/acad/add',
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
                    }
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
                    url: '/acad/del',
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
            //填充原始数据
            $.ajax({
                type:'POST',
                url:'/teacher/teacherListData',
                async:false,
                success:function (resData) {
                    $.each(resData.data, function (index,value) {
                        teacher_name.append(new Option(value.teacher_name,value.id));
                    })
                }
            })
            form.val('addAcad', {
                'acad_name': data.acad_name,
            })
            teacher_name.val(data.teacher_id);
            layui.form.render('select');
            //表单提交
            layer.open({
                type: 1,
                area: ['50%', '50%'],
                btn: ['确认', '取消'],
                content: $('#addAcad'),
                yes: function (index) {
                    var acaData = form.val('addAcad')
                    $.ajax({
                            type: "POST",
                            data: {
                                'id': data.id,
                                'acad_name': acaData.acad_name,
                                'manager_id': acaData.teacher_name
                            },
                            url: '/acad/update',
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
                }
            })
        }
    });
});
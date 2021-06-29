layui.use(['table', 'jquery', 'form'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var form = layui.form;
    var coordinator = $('#coordinator');
    var acad = $('#acad');
    table.render({
        elem: '#clazzData'
        , url: '/clazz/clazzListData'
        , toolbar: '#toolBar'//开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            , layEvent: 'LAYTABLE_TIPS'
            , icon: 'layui-icon-tips'
        }]
        , title: '课程列表'
        , cols: [
            [
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'ID', fixed: 'left', unresize: true, sort: true}
                , {field: 'clazz_name', title: '班级', edit: 'text'}
                , {field: 'number', title: '人数', edit: 'text'}
                , {field: 'coordinator_name', title: '班主任', edit: 'text'}
                , {field: 'acad_name', title: '学院', edit: 'text'}
                , {fixed: 'right', title: '操作', toolbar: '#actBar'}
            ]
        ]
        , page: true
    });
    //头工具栏事件
    table.on('toolbar(clazzData)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getAddData':
                $('#clazzInfo')[0].reset();
                allSelect();
                form.render("select");
                layer.open({
                    type: 1,
                    area: ['50%', '50%'],
                    btn: ['确认', '取消'],
                    yes: function (index) {
                        var clazzData = form.val('clazzInfo');
                        $.ajax({
                                type: "POST",
                                data: {
                                    'id': clazzData.id,
                                    'clazz_name': clazzData.clazz_name,
                                    'number': clazzData.number,
                                    'coordinator_id': clazzData.coordinator,
                                    'acad_id': clazzData.acad,
                                },
                                url: '/clazz/insertClazz',
                                success: function (resData) {
                                    if (resData === 1) {
                                        alert("添加成功！");
                                        layer.close(index);
                                        location.reload();
                                    } else {
                                        alert("添加失败了！");
                                    }
                                }
                            }
                        )
                    },
                    content: $('#clazzInfo')
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
    table.on('tool(clazzData)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    type: "POST",
                    data: {
                        'id': data.id
                    },
                    url: '/clazz/deleteClazz',
                    error: function (XMLHttpRequest) {
                        alert("删除失败了!");
                        alert(XMLHttpRequest.status);
                    },
                    success: function (resData) {
                        if (resData === 1) {
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
            allSelect();
            acad.val(data.acad_id);
            coordinator.val(data.coordinator_id);
            form.render("select")
            form.val('clazzInfo', {
                'id': data.id,
                'clazz_name': data.clazz_name,
                'number': data.number,
            })
            layer.open({
                type: 1,
                area: ['50%', '50%'],
                btn: ['确认', '取消'],
                yes: function (index) {
                    var clazzData = form.val('clazzInfo')
                    $.ajax({
                            type: "POST",
                            data: {
                                'id': clazzData.id,
                                'clazz_name': clazzData.clazz,
                                'number': clazzData.number,
                                'coordinator_id': clazzData.coordinator,
                                'acad_id': clazzData.acad,
                            },
                            url: '/clazz/updateClazz',
                            error: function (XMLHttpRequest) {
                                alert("更新失败了!");
                                alert(XMLHttpRequest.status);
                            },
                            success: function (resData) {
                                if (resData === 1) {
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
                content: $('#clazzInfo')
            })
        }
    });

    //下拉框赋值
    function allSelect() {
        acad.empty();
        $.ajax({
            type: "POST",
            url: '/acad/findAll',
            async: false,
            success: function (resData) {
                $.each(resData, function (index, value) {
                    acad.append(new Option(value.acad_name, value.id,));
                })
            }
        })
        coordinator.empty();
        $.ajax({
            type: "POST",
            url: '/teacher/findAll',
            async: false,
            success: function (resData) {
                $.each(resData, function (index, value) {
                    coordinator.append(new Option(value.teacher_name, value.id,));
                })
            }
        })
    }

});
layui.use(['table', 'jquery', 'form'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var form = layui.form;
    var teacher = $('#teacher');
    var course = $('#course');
    var clazz = $('#clazz');
    if (role === 0) {
        url = "/course/scheListData?role=" + role + "";
    } else if (role === 1) {
        url = "/course/scheListData?role=" + role + "&tId=" + tId;
    } else if (role === 2) {
        url = "/course/scheListData?role=" + role + "&cId=" + cId;
    }
    table.render({
        elem: '#scheData'
        , url: url
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
                , {field: 'course_name', title: '课程名', edit: 'text'}
                , {field: 'teacher_name', title: '教师', edit: 'text'}
                , {field: 'clazz_name', title: '班级', edit: 'text'}
                , {field: 'room', title: '教室', edit: 'text'}
                , {field: 'course_time', title: '上课时间', edit: 'text'}
                , {field: 'course_week', title: '上课周次', edit: 'text'}
                , {fixed: 'right', title: '操作', toolbar: '#actBar'}
            ]
        ]
        , page: true
    });
    //头工具栏事件
    table.on('toolbar(scheData)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getAddData':
                $('#scheInfo')[0].reset();
                allSelect();
                form.render("select");
                layer.open({
                    type: 1,
                    area: ['50%', '50%'],
                    btn: ['确认', '取消'],
                    yes: function (index) {
                        var scheData = form.val('scheInfo');
                        $.ajax({
                                type: "POST",
                                data: {
                                    'id': scheData.id,
                                    'course_id': scheData.course,
                                    'teacher_id': scheData.teacher,
                                    'clazz_id': scheData.clazz,
                                    'room': scheData.room,
                                    'course_time': scheData.course_time,
                                    'course_week': scheData.course_week,
                                },
                                url: '/course/addSche',
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
                    content: $('#scheInfo')
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
    table.on('tool(scheData)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    type: "POST",
                    data: {
                        'id': data.id
                    },
                    url: '/course/deleteSche',
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
            course.val(data.course_id);
            teacher.val(data.teacher_id);
            clazz.val(data.clazz_id);
            form.render("select")
            form.val('scheInfo', {
                'id': data.id,
                'room': data.room,
                'course_time': data.course_time,
                'course_week': data.course_week,
            })
            layer.open({
                type: 1,
                area: ['50%', '50%'],
                btn: ['确认', '取消'],
                yes: function (index) {
                    var scheData = form.val('scheInfo')
                    $.ajax({
                            type: "POST",
                            data: {
                                'id': scheData.id,
                                'course_id': scheData.course,
                                'teacher_id': scheData.teacher,
                                'clazz_id': scheData.clazz,
                                'room': scheData.room,
                                'course_time': scheData.course_time,
                                'course_week': scheData.course_week,
                            },
                            url: '/course/updateSche',
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
                content: $('#scheInfo')
            })
        }
    });

    //下拉框赋值
    function allSelect() {
        course.empty();
        $.ajax({
            type: "POST",
            url: '/course/findAll',
            async: false,
            success: function (resData) {
                $.each(resData, function (index, value) {
                    course.append(new Option(value.course_name, value.id,));
                })
            }
        })
        teacher.empty();
        $.ajax({
            type: "POST",
            url: '/teacher/findAll',
            async: false,
            success: function (resData) {
                $.each(resData, function (index, value) {
                    teacher.append(new Option(value.teacher_name, value.id,));
                })
            }
        })
        clazz.empty();
        $.ajax({
            type: "POST",
            url: '/clazz/findAll',
            async: false,
            success: function (resData) {
                $.each(resData, function (index, value) {
                    clazz.append(new Option(value.clazz_name, value.id,));
                })
            }
        })
    }

});
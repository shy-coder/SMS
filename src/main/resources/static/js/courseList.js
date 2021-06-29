layui.use(['table', 'jquery', 'form'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var form = layui.form;
    var courseInfo = $('#courseInfo')
    table.render({
        elem: '#courseData'
        , url: '/course/courseListData'
        , toolbar: '#toolBar' //开启头部工具栏，并为其绑定左侧模板
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
                , {field: 'cno', title: '课程号', edit: 'text'}
                , {field: 'course_name', title: '课程名', edit: 'text'}
                , {fixed: 'right', title: '操作', toolbar: '#actBar'}
            ]
        ]
        , page: true
    });

    //头工具栏事件
    table.on('toolbar(courseData)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getAddData':
              courseInfo[0].reset();
                layer.open({
                    content: courseInfo,
                    type: 1,
                    area: ['50%', '50%'],
                    btn: ['确认', '取消'],
                    yes: function (index) {
                        var courseData = form.val('courseInfo')
                        $.ajax({
                                type: "POST",
                                data: {
                                    'cno': courseData.cno,
                                    'course_name': courseData.course_name
                                },
                                url: '/course/insertCourse',
                                error: function (XMLHttpRequest) {
                                    alert("添加失败了!");
                                    alert(XMLHttpRequest);
                                },
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
    table.on('tool(courseData)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    type: "POST",
                    data: {
                        'id': data.id
                    },
                    url: '/course/deleteCourse',
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
            form.val('courseInfo', {
                'cno': data.cno,
                'course_name':data.course_name
            })
            //表单提交
            layer.open({
                type: 1,
                area: ['50%', '50%'],
                btn: ['确认', '取消'],
                yes: function (index) {
                    var courseData = form.val('courseInfo')
                    $.ajax({
                            type: "POST",
                            data: {
                                'id': data.id,
                                'cno': courseData.cno,
                                'course_name': courseData.course_name
                            },
                            url: '/course/updateCourse',
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
                content: courseInfo,
            })
        }
    });
});
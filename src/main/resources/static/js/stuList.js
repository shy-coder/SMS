layui.use(['form','table','upload', 'element', 'layer'], function(){
    const $ = layui.jquery
        , upload = layui.upload
        , element = layui.element
        , layer = layui.layer
        , form = layui.form;
    const table = layui.table;
    const url = $("#ctx").val();
    var file;
    console.log(url.toString());

    table.render({
        elem: '#test'
        ,url:'/stu/list'
        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }]
        ,title: '用户数据表'
        ,cols:
            [
                [
                    {type: 'checkbox', fixed: 'left'}
                    ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
                    ,{field:'sno', title:'学号', width:80, edit: 'text'}
                    ,{field:'username', title:'姓名', width:100, edit: 'text'}
                    ,{field:'password', title:'密码', width:100, edit: 'text'}
                    ,{field:'gender', title:'性别', width:60, edit: 'text'}
                    ,{field:'email', title:'邮箱', width:130, edit: 'text', templet: function(res){
                        return '<em>'+ res.email +'</em>'
                    }}
                    ,{field:'telephone', title:'电话', width:130, edit: 'text'}
                    ,{field:'address', title:'城市', width:70}
                    ,{field:'introduce', title: '介绍',width: 130}
                    ,{field:'portrait_path', title:'头像',templet:'<div><img  src="{{ d.portrait_path }}"></div>',width: 120,}
                    ,{field:'clazz_id', title:'班级', width:80}
                    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
                ]
            ]
        ,page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            //新增学生
            case 'addStudent':
                layer.open({
                    type: 1,
                    title:"新增",
                    area:['50%','50%'],
                    btn: ['确定', '取消'],
                    content: $("#window"),
                    yes:function(index){
                        var stuData = form.val('example')
                        $.getJSON('/stu/add',{
                            sno: $('#sno').val(),
                            username: $('#username').val(),
                            password: $('#password').val(),
                            gender: $('input[name="sex"]:checked').val(),
                            email: $('#email').val(),
                            telephone: $('#telephone').val(),
                            address: $('#address').val(),
                            introduce: $('#introduce').val(),
                            portrait_path: file,
                            clazz_id:stuData.clazz_id
                        },function(data){
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
                        });
                    }
                });
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选': '未全选');
                break;

            //自定义头工具栏右侧图标 - 提示
            case 'LAYTABLE_TIPS':
                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                break;
        };
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
            console.log("!!!!!!!!"+res.data.src);
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
    table.on('tool(test)', function(obj){
        var data = obj.data;
        //console.log(obj)
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.prompt({
                formType: 2
                ,value: data.email
            }, function(value, index){
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });
});
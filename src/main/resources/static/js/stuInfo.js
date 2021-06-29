window.onload=function() {
    console.log("!!!!!!!!!!!!!!!!!!!!!")
    var sessionData = document.getElementById(`sessionData`);
    console.log(sessionData.value);
    alert(sessionData.val)
}

layui.use(['form'], function(){
    const form = layui.form
        , layer = layui.layer





    //表单赋值
    // layui.$('#LAY-component-form-setval').on('click', function(){
    //     form.val('example', {
    //         "username": "贤心" // "name": "value"
    //         ,"password": "123456"
    //         ,"interest": 1
    //         ,"like[write]": true //复选框选中状态
    //         ,"close": true //开关状态
    //         ,"sex": "女"
    //         ,"desc": "我爱 layui"
    //     });
    // });

});
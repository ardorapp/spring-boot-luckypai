let tableIns;
layui.use(['element', 'form', 'table', 'layer', 'laydate', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    let height = document.documentElement.clientHeight - 160;

    //资产列表
    tableIns = table.render({
        elem: '#luckycashTable'
        , url: ctx + '/assets/luckycash/page'
        , method: 'POST'
        //请求前参数处理
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'rows' //每页数据量的参数名，默认：limit
        }
        , response: {
            statusName: 'flag' //规定数据状态的字段名称，默认：code
            , statusCode: true //规定成功的状态码，默认：0
            , msgName: 'msg' //规定状态信息的字段名称，默认：msg
            , countName: 'records' //规定数据总数的字段名称，默认：count
            , dataName: 'rows' //规定数据列表的字段名称，默认：data
        }
        //响应后数据处理
        , parseData: function (res) { //res 即为原始返回的数据
            var data = res.data;
            console.log("=====================");
            console.log(data);
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.records, //解析数据长度
                "rows": data.rows //解析数据列表
            };
        }
        , toolbar: '#luckycashTableToolbarDemo'
        , title: '我创建的红包列表'
        , cols: [[
            {field: 'luckycashId', title: '红包ID'}
            , {field: 'assetsId', title: '资产'}
            , {field: 'amountTotal', title: '总金额'}
            , {field: 'packetTitle', title: '标题'}
            , {field: 'status', title: '状态'}
            , {field: 'packetContent', title: '内容', hide: true}
            , {fixed: 'right', title: '操作', toolbar: '#luckycashTableBarDemo'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        switch (obj.event) {
            case 'addData':
                //重置操作表单
                $("#luckycashForm")[0].reset();
                let nowTime = commonUtil.getNowTime();
                $("input[name='createTime']").val(nowTime);
                $("input[name='updateTime']").val(nowTime);
                form.render();
                layer.msg("请填写右边的表单并保存！");
                break;
        }
    });

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        let data = obj.data;
        //删除
        if (obj.event === 'del') {
            layer.confirm('确认删除吗？', function (index) {
                //向服务端发送删除指令
                $.delete(ctx + "/assets/luckycash/delete/" + data.luckycashId, {}, function (data) {
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }
        //编辑
        else if (obj.event === 'edit') {
            //回显操作表单
            $("#luckycashForm").form(data);
            form.render();
        }
    });

    //日期选择器
    laydate.render({
        elem: '#expiredTimeDate',
        format: "yyyy-MM-dd HH:mm:ss"
    });
});

/**
 * 提交保存
 */
function luckycashFormSave() {
    let luckycashForm = $("#luckycashForm").serializeObject();
    luckycashForm.updateTime = commonUtil.getNowTime();
    $.post(ctx + "/assets/luckycash/save", luckycashForm, function (data) {
        layer.msg("保存成功", {icon: 1, time: 2000}, function () {});
        //更新table、updateTime
        $("input[name='updateTime']").val(luckycashForm.updateTime);
        tableIns.reload();
    });
}
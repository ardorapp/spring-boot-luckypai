let tableIns;
layui.use(['element', 'form', 'table', 'layer', 'laydate', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    let height = document.documentElement.clientHeight - 160;

    //资产列表
    tableIns = table.render({
        elem: '#assetsTable'
        , url: ctx + '/assets/info/page'
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
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.records, //解析数据长度
                "rows": data.rows //解析数据列表
            };
        }
        , toolbar: '#assetsTableToolbarDemo'
        , title: '资产列表'
        , cols: [[
            {field: 'assetsId', title: 'ID', hide: true}
            , {field: 'assetsSymbol', title: '资产符号'}
            , {field: 'assetsName', title: '资产名称'}
            , {field: 'assetsNameZh', title: '中文名称'}
            , {field: 'assetsIntroduction', title: '资产介绍', hide: true}
            , {field: 'assetsHome', title: '资产官网', hide: true}
            , {field: 'lastBlockHeight', title: '最新区块高度', hide: true}
            , {field: 'lastBlockTime', title: '最新区块时间', hide: true}
            , {field: 'createTime', title: '创建时间', hide: true}
            , {field: 'updateTime', title: '更新时间', hide: true}
            , {fixed: 'right', title: '操作', toolbar: '#assetsTableBarDemo'}
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
                $("#assetsForm")[0].reset();
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
                $.delete(ctx + "/assets/info/delete/" + data.assetsId, {}, function (data) {
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }
        //编辑
        else if (obj.event === 'edit') {
            //回显操作表单
            $("#assetsForm").form(data);
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
function assetsFormSave() {
    let assetsForm = $("#assetsForm").serializeObject();
    assetsForm.updateTime = commonUtil.getNowTime();
    $.post(ctx + "/assets/info/save", assetsForm, function (data) {
        layer.msg("保存成功", {icon: 1, time: 2000}, function () {});
        //更新table、updateTime
        $("input[name='updateTime']").val(assetsForm.updateTime);
        tableIns.reload();
    });
}
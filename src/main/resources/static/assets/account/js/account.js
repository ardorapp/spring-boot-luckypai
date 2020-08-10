let tableIns;
layui.use(['element', 'form', 'table', 'layer', 'laydate', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    let height = document.documentElement.clientHeight - 160;

    //资产列表
    tableIns = table.render({
        elem: '#accountTable'
        , url: ctx + '/assets/account/page'
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
        , title: '账号列表'
        , cols: [[
            {field: 'id', title: 'ID', hide: true}
            , {field: 'userId', title: 'userId',hide: true}
            , {field: 'assetsId', title: 'assetsId',hide: true}
            , {field: 'assetsSymbol', title: '资产名称',
                templet:function(data){
                    if(data.walletAssets) return data.walletAssets.assetsSymbol;
                    return ''
                }
            }
            , {field: 'receiveAccount', title: 'receiveAccount',hide: true}
            , {field: 'receiveAddress', title: 'receiveAddress',hide: true}
            , {field: 'receiveBalance', title: '已收红包金额'}
            , {field: 'sendAddress', title: 'sendAddress',hide: true}
            , {field: 'sendBalance', title: '待发红包余额'}
            , {field: 'createTime', title: '创建时间', hide: true}
            , {field: 'updateTime', title: '更新时间', hide: true}
            , {fixed: 'right', title: '操作', toolbar: '#accountTableBarDemo'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        let data = obj.data;
        //编辑
        if (obj.event === 'edit') {
            //回显操作表单
            data.assetsSymbol = data.walletAssets.assetsSymbol;
            $("#accountForm").form(data);
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
function accountFormSave() {
    let accountForm = $("#accountForm").serializeObject();
    accountForm.updateTime = commonUtil.getNowTime();
    $.post(ctx + "/assets/account/saveReceiveAddress", accountForm, function (data) {
        if (!data.flag) {
            layer.msg("保存失败："+data.msg+" ,请重新输入。", {icon: 1, time: 2000}, function () {});
        } else {
            layer.msg("保存成功 ", {icon: 1, time: 2000}, function () {});
            //更新table、updateTime
            $("input[name='updateTime']").val(accountForm.updateTime);
            tableIns.reload();
        }
    });
}
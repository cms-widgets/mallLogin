/**
 * Created by lhx on 2016/8/11.
 */
CMSWidgets.initWidget({
// 编辑器相关
    editor: {
        saveComponent: function (onFailed) {
            this.properties.pageSerial = $("select[name='pageSerial']").val();
            var nodes = $.getTreeViewData();
            this.properties.pageIds = nodes;
        },
        initProperties: function () {
            var that = this;
            if (that.properties.pageIds == undefined) {
                var node = [{
                    "flag": 0,
                    "isParent": "false",
                    "visible": "",
                    "linkPath": "",
                    "name": "注册",
                    "visibleName": "",
                    "visibleValue": "",
                    "id": 1
                }];

                $('#treeView').addTreeView({
                    treeNodes: node
                });
            } else {
                $('#treeView').addTreeView({
                    treeNodes: that.properties.pageIds
                });
            }
        },
        open: function (globalId) {
            this.initProperties();
        }
    }
});

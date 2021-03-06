<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- AdminLTE必须 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"> -->
<script src="${staticPath}/static/jquery/jquery-3.5.1.min.js"></script>
<%-- <link rel="stylesheet" type="text/css" href="${staticPath}/static/jquery-easyui-1.7.0/themes/default/easyui.css"> --%>
<%-- <link rel="stylesheet" type="text/css" href="${staticPath}/static/jquery-easyui-1.7.0/themes/icon.css"> --%>
<link rel="stylesheet" href="${staticPath}/static/img/icon-font/iconfont.css"><!-- 阿里巴巴矢量图标 -->
<%-- <script src="${staticPath}/static/jquery-easyui-1.7.0/jquery.min.js"></script> --%>
<%-- <script defer="defer" src="${staticPath}/static/jquery-easyui-1.7.0/jquery.easyui.min.js"></script> --%>
<%-- <script defer="defer" src="${staticPath}/static/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script> --%>
<script defer="defer" src="${staticPath}/static/jsUtil/jsUtil.js"></script>
<%-- <script defer="defer" src="${staticPath}/static/jsUtil/extraJs.js"></script> --%>
<!-- <script src ="canvas-nest.js-2.0.1/dist/newnest.js"></script> -->
<script defer="defer" src="${staticPath}/static/echarts/echarts.min.js"></script>
<%-- <script defer="defer" src="${staticPath}/static/echarts/echarts-gl.min.js"></script> --%>
<!-- <link rel="shortcut icon" href="/favicon.ico" /> -->
<!-- <link rel="bookmark" href="/favicon.ico" type="image/x-icon"　/> -->
<!-- Bootstrap 4.5.0 如果你使用的是我们编译过的 JavaScript，不要忘记在它之前引入 jQuery 和 Popper.js jQuery在前,Popper在中间,Bootstrap最后 -->
<script defer="defer" src="${staticPath}/static/popper.js-1.6.1/popper.min.js"></script>
<link rel="stylesheet" href="${staticPath}/static/bootstrap-4.5.0-dist/css/bootstrap.min.css">
<script defer="defer" src="${staticPath}/static/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
<!-- font-awesome-4.7.0 -->
<link rel="stylesheet" href="${staticPath}/static/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- AdminLTE专用图标 需要区分fab far fas等等 -->
<%-- <link rel="stylesheet" href="${staticPath}/static/font-awesome-4.7.0/css/all.min.css"> --%>
<link rel="stylesheet" href="${staticPath}/static/ionicons-5.0.0/docs/css/ionicons.min.css">
<!-- AdminLTE -->
<link rel="stylesheet" href="${staticPath}/static/AdminLTE-3.0.5/dist/css/adminlte.min.css">
<!-- AdminLTE App -->
<script defer="defer" src="${staticPath}/static/AdminLTE-3.0.5/dist/js/adminlte.min.js"></script>
<%-- <link rel="stylesheet" href="${staticPath}/static/AdminLTE-3.0.5/dist/css/skins/_all-skins.min.css"> --%>
<!-- icheck -->
<%-- <link rel="stylesheet" href="${staticPath}/static/AdminLTE-3.0.5/plugins/icheck-bootstrap/icheck-bootstrap.min.css"> --%>
<link rel="stylesheet" href="${staticPath}/static/AdminLTE-3.0.5/plugins/iCheck/square/square.css">
<script defer="defer" src="${staticPath}/static/AdminLTE-3.0.5/plugins/iCheck/icheck.min.js"></script>
<!-- pace pace.css可自定义样式:https://github.hubspot.com/pace/docs/welcome/ -->
<link rel="stylesheet" href="${staticPath}/static/AdminLTE-3.0.5/plugins/pace/pace.min.css">
<script defer="defer" src="${staticPath}/static/AdminLTE-3.0.5/plugins/pace/pace.min.js"></script>
<!-- DataTables -->
<link rel="stylesheet" href="${staticPath}/static/DataTables-1.10.21/media/css/jquery.dataTables.css">
<script src="${staticPath}/static/DataTables-1.10.21/media/js/jquery.dataTables.js"></script>
<!-- <link rel="stylesheet" href="./static/DataTables-1.10.21/media/css/dataTables.bootstrap4.min.css"> -->
<!-- Select2 -->
<link rel="stylesheet" href="${staticPath}/static/select2-4.0.13/dist/css/select2.min.css">
<script defer="defer" src="${staticPath}/static/select2-4.0.13/dist/js/select2.min.js"></script>
<script defer="defer" src="${staticPath}/static/select2-4.0.13/dist/js/select2tree.js"></script>
<!-- datetimepicker -->
<link rel="stylesheet" href="${staticPath}/static/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
<script defer="defer" src="${staticPath}/static/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script defer="defer" src="${staticPath}/static/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- layer -->
<script defer="defer" src="${staticPath}/static/layer/layer.js"></script>
<!-- ZTREE -->
<link rel="stylesheet" href="${staticPath}/static/ztree/zTreeStyle.css"">
<script defer="defer" src="${staticPath}/static/ztree/jquery.ztree.forGisardAdminLTE3.0.5.js"></script>
<!-- customized basic css -->
<link rel="stylesheet" href="${staticPath}/static/css/customized-basic.css">
<link rel="stylesheet" href="${staticPath}/static/AdminLTE-3.0.5/plugins/jqvmap/jqvmap.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet" href="${staticPath}/static/AdminLTE-3.0.5/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<script defer="defer" src="${staticPath}/static/AdminLTE-3.0.5/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- summernote -->
<link rel="stylesheet" href="${staticPath}/static/AdminLTE-3.0.5/plugins/summernote/summernote-bs4.css">
<script defer="defer" src="${staticPath}/static/AdminLTE-3.0.5/plugins/summernote/summernote-bs4.min.js"></script>
<!-- control-sidebar-content -->
<script defer="defer" src="${staticPath}/static/AdminLTE-3.0.5/dist/js/demo.js"></script>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700">
<script>
$.postJSON = function(url, data, callback) {
    return jQuery.ajax( {
        'type' : 'POST',
        'url' : url,
        'contentType' : 'application/json;charset=UTF-8',
        'data' : JSON.stringify(data),
        'dataType' : 'json',
        'success' : callback
    });
};
//配置DataTables默认参数
$.extend(true, $.fn.dataTable.defaults, {
    "language": {
    	"url": "./static/DataTables-1.10.21/assets/Chinese.txt",
    	
    },
    pagingType: "full_numbers",
	autoWidth: true,
	searching: false,
	serverSide: true,
    "columnDefs": [ {
        "targets": '_all',//将所有列的空值变为''空字符串,防止报Requested unknown parameter 'xxx',please see http://datatables.net/tn/4错误
        "defaultContent": '',
      } ]
});
</script>
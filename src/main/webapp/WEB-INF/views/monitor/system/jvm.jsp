<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="UTF-8" src="http://static.battcn.com/back/js/jquery.min.js?v=2.1.4"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/common/plugins/highchart/highcharts.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/common/plugins/highchart/highcharts-more.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/common/plugins/highchart/modules/exporting.js"></script>
<script type="text/javascript">
$(function(){
	  Highcharts.setOptions({                                                     
          global: {                                                               
              useUTC: false                                                       
          }                                                                       
      }); 
	  var chart = new Highcharts.Chart({
	        chart: {
	            renderTo: 'realtimeContainer',
	            type: 'spline',
	            animation: Highcharts.svg, // don't animate in old IE  
	            marginRight: 10, 
	            events: {
	                load: function() {
	                    var series = this.series;
	                     var loadData = function(){
	                    	$.ajax({
	                    		url:'${pageContext.request.contextPath}/system/getJVM.shtml',
	                    		type:'post',
	                    		async:false,
	                    		success:function(data){
	    	                        series[0].addPoint([data.x, data.y], true, true);
	                    		}
	                    	});
	                    	
	                    };
	                    loadData();
	                    setInterval(loadData, 5000);  
	                }
	            }
	        },
	        credits : {
	        	enabled:false
	        },
	        title: {
	            text: 'JAVA虚拟机/JVM实时监控(可分配总内存：${maxMemory}M  已分配总内存：${totalMemory}M    )' 
	        },
	        xAxis: {
	            type: 'datetime',
	            tickPixelInterval: 150,
	            gridLineWidth: 1,//默认是0，即在图上没有纵轴间隔线
	            //自定义x刻度上显示的时间格式，根据间隔大小，以下面预设的小时/分钟/日的格式来显示
	            dateTimeLabelFormats: {
	            	second: '%H:%M:%S'
	            }
	        },
	        yAxis: [{
	            title: {
	                text: '内存（MB）',
	                style: {
	                	color: '#00AA00'
	                }
	            }
	        }],
	         plotOptions: {
	        	spline: {
	        		animation:true,
	        		marker:{
	        		    enabled: true
	        		}
	       		}
	       	}, 
	       	tooltip: {
	       		shared: true,
	       		crosshairs: true
	       	},
	        legend: {
	            enabled: true
	        },
	        exporting: {
	            enabled: false
	        },
	        series: [{
	            name: '已使用内存',
	            data: (function() {
	            	 var data = [],  time = (new Date()).getTime(), i;
	            	 $.ajax({
                 		url:'${pageContext.request.contextPath}/system/getAll.shtml',
                 		type:'post',
                 		async:false,
                 		success:function(datas){
                 			data = datas;
                 		}
                 	});
	                return data;
	            })()
	        }]
	    });
})
</script>
<div id="realtimeContainer" style="width: 100%; height: 100%;"></div>
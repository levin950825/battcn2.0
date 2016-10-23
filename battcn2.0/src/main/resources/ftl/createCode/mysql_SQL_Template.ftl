
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `${tablePre}${proClassUpper}`
-- ----------------------------
DROP TABLE IF EXISTS `${tablePre}${proClassUpper}`;
CREATE TABLE `${tablePre}${proClassUpper}` (
 	`ID` INT(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
<#list fieldList as var>
	<#if var.attributeType == 'Integer'>
	`${var.attributeName}` int(8) DEFAULT '${var.defaultVal}' COMMENT '${var.remake}',
	<#else>
	`${var.attributeName}` varchar(255) DEFAULT '${var.defaultVal}' COMMENT '${var.remake}',
	</#if>
</#list>
  	PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

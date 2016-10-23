-- ----------------------------
-- Table structure for "C##NEWO"."${tablePre}${proClassUpper}"
-- ----------------------------
-- DROP TABLE "C##NEWO"."${tablePre}${proClassUpper}";
CREATE TABLE "C##NEWO"."${tablePre}${proClassUpper}" (
<#list fieldList as var>
	<#if var.attributeType == 'Integer'>
	"${var.attributeName}" NUMBER(10) NULL ,
	<#else>
	"${var.attributeName}" VARCHAR2(255 BYTE) NULL ,
	</#if>
</#list>
	"${proClassUpper}_ID" VARCHAR2(100 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE
;

<#list fieldList as var>
COMMENT ON COLUMN "C##NEWO"."${tablePre}${proClassUpper}"."${var.attributeName}" IS '${var.remake}';
</#list>
COMMENT ON COLUMN "C##NEWO"."${tablePre}${proClassUpper}"."${proClassUpper}_ID" IS 'ID';

-- ----------------------------
-- Indexes structure for table ${tablePre}${proClassUpper}
-- ----------------------------

-- ----------------------------
-- Checks structure for table "C##NEWO"."${tablePre}${proClassUpper}"

-- ----------------------------

ALTER TABLE "C##NEWO"."${tablePre}${proClassUpper}" ADD CHECK ("${proClassUpper}_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table "C##NEWO"."${tablePre}${proClassUpper}"
-- ----------------------------
ALTER TABLE "C##NEWO"."${tablePre}${proClassUpper}" ADD PRIMARY KEY ("${proClassUpper}_ID");

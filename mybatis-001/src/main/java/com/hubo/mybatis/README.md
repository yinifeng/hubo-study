1.oralce批量insert
1):
<insert id="insertAttractionsBatch" parameterType="Java.util.List">
insert into ATTRACTIONS (ID, NAME, LONGITUDE, LATITUDE,  UPDATE_TIME)
  <foreach collection="list" item="item" index="index" separator="union all" > 
      (select  
		#{item.id,jdbcType=VARCHAR}, #{item.name,jdbcType=VARCHAR}, #{item.longitude,jdbcType=DECIMAL}, #{item.updateTime,jdbcType=TIMESTAMP}
       from dual)
  </foreach>
</insert>

2):
<insert id="addSupCity" parameterType="java.util.List">
   INSERT INTO T_OCL_SUPCITY
  (CITY_ID,CITY_CODE, CITY_NAME, AREA_DESC, SUP_ID, STAT)
SELECT SEQ_OCL_SUPCITY.NEXTVAL CITY_ID, A.*
FROM(
	<foreach collection="list" item="item" index="index" separator="UNION ALL">
		 SELECT 
		       #{item.cityCode,jdbcType=VARCHAR} CITY_CODE,
		       #{item.cityName,jdbcType=VARCHAR} CITY_NAME,
		       #{item.areaDesc,jdbcType=VARCHAR} AREA_DESC,
		       #{item.supId,jdbcType=VARCHAR} SUP_ID,
		       #{item.stat,jdbcType=VARCHAR} STAT
		     FROM dual
   </foreach>
   )A
 </insert>
 
 3):
 insert  into db(id, zgbh, shbzh)   
        select '1', '2', '3' from dual   
        union all select '2', '3', '4' from dual   
        union all select '3', '4', '5' from dual   
        union all select '4', '5', '6' from dual   
        union all select '5', '6', '7' from dual 
 
 <insert id="insertMoSmsList" parameterType="com.xxx.XxxBean">  
    INSERT INTO TBL_xxx_DETAIL  
    (  
        id, zgbh, shbzh, ReceiveTime  
    ) SELECT SEQ_xxx_DETAIL.NEXTVAL, A.* FROM(  
    <foreach collection="list" item="item" index="index" separator="UNION ALL">  
    <![CDATA[  
        SELECT  
            #{item.id, jdbcType=INTEGER} AS id,  
            #{item.zgbh, jdbcType=VARCHAR} AS zgbh,  
            #{item.shbzh, jdbcType=VARCHAR} AS shbzh,  
            TO_DATE(#{item.receiveTime, jdbcType=DATE},'yyyy-mm-dd hh24:mi:ss') AS ReceiveTime  
        FROM dual  
    ]]>  
    </foreach>  
    ) A   
</insert>  


2:oracle 主键生成
<insert id="saveUserInfo" parameterType="UserInfo">
        <selectKey resultType="int"  keyProperty="userId" order="BEFORE">   
            <![CDATA[SELECT SEQ_COMMON.NEXTVAL AS ID FROM DUAL]]>   
          </selectKey>
        <![CDATA[insert into userinfo(userId,userName,phone,age,birthday,remark) 
        values(#{userId},#{userName},#{phone},#{age},#{birthday},#{remark})]]>
</insert>       
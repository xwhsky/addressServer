package hkc.address.entity;

import java.util.Date;

public class Address {
    private String guid;

    private Integer objectid;

    private String name;

    private String commonName;

    private String address;

    private String province;

    private String city;

    private String county;

    private String town;

    private String communit;

    private String street;

    private String lane;

    private String doorplate;

    private String resreg;

    private String village;

    private String devreg;

    private String region;

    private String doorplate1;

    private String doorplate2;

    private String room;

    private String addpinyin;

    private Double lon;

    private Double lat;

    private String addtype;

    private String remark;

    private String scode;

    private String modifer;

    private Date createTime;

    private Date updateTime;

    private String dataStatus;

    private String ysbm;

    private Object geom;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public Integer getObjectid() {
        return objectid;
    }

    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName == null ? null : commonName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public String getCommunit() {
        return communit;
    }

    public void setCommunit(String communit) {
        this.communit = communit == null ? null : communit.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane == null ? null : lane.trim();
    }

    public String getDoorplate() {
        return doorplate;
    }

    public void setDoorplate(String doorplate) {
        this.doorplate = doorplate == null ? null : doorplate.trim();
    }

    public String getResreg() {
        return resreg;
    }

    public void setResreg(String resreg) {
        this.resreg = resreg == null ? null : resreg.trim();
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village == null ? null : village.trim();
    }

    public String getDevreg() {
        return devreg;
    }

    public void setDevreg(String devreg) {
        this.devreg = devreg == null ? null : devreg.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getDoorplate1() {
        return doorplate1;
    }

    public void setDoorplate1(String doorplate1) {
        this.doorplate1 = doorplate1 == null ? null : doorplate1.trim();
    }

    public String getDoorplate2() {
        return doorplate2;
    }

    public void setDoorplate2(String doorplate2) {
        this.doorplate2 = doorplate2 == null ? null : doorplate2.trim();
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room == null ? null : room.trim();
    }

    public String getAddpinyin() {
        return addpinyin;
    }

    public void setAddpinyin(String addpinyin) {
        this.addpinyin = addpinyin == null ? null : addpinyin.trim();
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getAddtype() {
        return addtype;
    }

    public void setAddtype(String addtype) {
        this.addtype = addtype == null ? null : addtype.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode == null ? null : scode.trim();
    }

    public String getModifer() {
        return modifer;
    }

    public void setModifer(String modifer) {
        this.modifer = modifer == null ? null : modifer.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }

    public String getYsbm() {
        return ysbm;
    }

    public void setYsbm(String ysbm) {
        this.ysbm = ysbm == null ? null : ysbm.trim();
    }

    public Object getGeom() {
        return geom;
    }

    public void setGeom(Object geom) {
        this.geom = geom;
    }
}
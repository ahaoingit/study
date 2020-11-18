package com.studyclass;

/**
 * TODO
 *
 * @author ahao 2020-09-27
 */
class Address{
    private String addressName;
    private String zipCode;
//get/set 方法
//构造方法

    public Address(String addressName, String zipCode) {
        this.addressName = addressName;
        this.zipCode = zipCode;
    }

    public Address() {
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
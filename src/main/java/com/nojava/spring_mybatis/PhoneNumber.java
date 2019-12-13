package com.nojava.spring_mybatis;

public class PhoneNumber {
    private String countryCode;
    private String stateCode;
    private String number;
    public PhoneNumber(){
    }
    public PhoneNumber(String countryCode, String stateCode, String number) {
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }

    public PhoneNumber(String str){
        if(str!=null){
            String[] args = str.split("-");
            this.countryCode = 	args[0];
            this.stateCode = 	args[1];
            this.number = 		args[2];
        }
    }

    public String getAsString() {
        return countryCode + "-" + stateCode + "-" + number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

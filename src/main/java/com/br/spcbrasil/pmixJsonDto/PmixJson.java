package com.br.spcbrasil.pmixJsonDto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PmixJson {

    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("params")
    @Expose
    private Params params;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("api_version")
    @Expose
    private String api_version;
    @SerializedName("provider")
    @Expose
    private String provider;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
    public PmixJson(){
        super();
    }

    public PmixJson(String password, Params params, String method, String api_version, String provider) {
        this.password = password;
        this.params = params;
        this.method = method;
        this.api_version = api_version;
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "ParamsDto [password=" + password + ", params=" + params + ", method="+ method + ",api_version="+ api_version+ ",provider=" + provider+ " ]";
    }
}
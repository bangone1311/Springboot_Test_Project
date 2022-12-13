package com.ahmad.dans.payload.response;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "type",
        "url",
        "created_at",
        "company",
        "company_url",
        "location",
        "title",
        "description",
        "how_to_apply",
        "company_logo"
})
@Generated("jsonschema2pojo")
public class JobResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("company")
    private String company;
    @JsonProperty("company_url")
    private String companyUrl;
    @JsonProperty("location")
    private String location;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("how_to_apply")
    private String howToApply;
    @JsonProperty("company_logo")
    private String companyLogo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E MMM dd HH:mm:ss z yyyy")
    public Date getCreatedAt() throws ParseException {
        return(createdAt);
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @JsonProperty("company_url")
    public String getCompanyUrl() {
        return companyUrl;
    }

    @JsonProperty("company_url")
    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("how_to_apply")
    public String getHowToApply() {
        return howToApply;
    }

    @JsonProperty("how_to_apply")
    public void setHowToApply(String howToApply) {
        this.howToApply = howToApply;
    }

    @JsonProperty("company_logo")
    public String getCompanyLogo() {
        return companyLogo;
    }

    @JsonProperty("company_logo")
    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
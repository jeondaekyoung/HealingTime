package com.healingtime.healingtime_designrenew;

public class DictionaryAromaDTO {
    private String section;
    private String aroma_name;
    private String aroma_sub_name;
    private String aroma_nickname;
    private String aroma_extract_part;
    private String aroma_extract_method;
    private String aroma_country_origin;
    private String aroma_detailed_instructions;
    private String aroma_color;
    private String aroma_blending_oil;
    private String aroma_history;
    private String aroma_caution;
    
    private int icon;

    public DictionaryAromaDTO(String section, Integer icon, String aroma_name, String aroma_sub_name, String aroma_nickname
            , String aroma_extract_part, String aroma_extract_method, String aroma_country_origin, String aroma_detailed_instructions, String aroma_color
            , String aroma_blending_oil, String aroma_history, String aroma_caution){

        this.section = section;
        this.icon = icon;
        this.aroma_name = aroma_name;
        
        this.aroma_sub_name = aroma_sub_name;
        this.aroma_nickname = aroma_nickname;
        this.aroma_extract_part = aroma_extract_part;
        this.aroma_extract_method = aroma_extract_method;
        this.aroma_country_origin = aroma_country_origin;
        this.aroma_detailed_instructions = aroma_detailed_instructions;
        this.aroma_color = aroma_color;
        this.aroma_blending_oil = aroma_blending_oil;
        this.aroma_history = aroma_history;
        this.aroma_caution = aroma_caution;

    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAroma_name() {
        return this.aroma_name;
    }

    public String getAroma_sub_name() {
        return this.aroma_sub_name;
    }

    public String getAroma_nickname() {
        return aroma_nickname;
    }

    public void setAroma_nickname(String aroma_nickname) {
        this.aroma_nickname = aroma_nickname;
    }

/*    public String getAroma_filename() {
        return aroma_filename;
    }*/

    public int getIcon() {
        return this.icon;
    }

    public String getAroma_extract_part() {
        return this.aroma_extract_part;
    }

    public String getAroma_extract_method() {
        return this.aroma_extract_method;
    }

    public String getAroma_country_origin() {
        return this.aroma_country_origin;
    }

    public String getAroma_detailed_instructions() {
        return this.aroma_detailed_instructions;
    }

    public String getAroma_color() {
        return this.aroma_color;
    }

    public String getAroma_blending_oil() {
        return this.aroma_blending_oil;
    }

    public String getAroma_history() {
        return this.aroma_history;
    }

    public String getAroma_caution() {
        return this.aroma_caution;
    }
}
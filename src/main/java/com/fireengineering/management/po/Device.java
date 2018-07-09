package com.fireengineering.management.po;

public class Device {
    private Integer id;

    private String name;

    private Integer firesystemId;

    private String note;

    private String img;

    private Firesystem firesystem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFiresystemId() {
        return firesystemId;
    }

    public void setFiresystemId(Integer firesystemId) {
        this.firesystemId = firesystemId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Firesystem getFiresystem() {
        return firesystem;
    }

    public void setFiresystem(Firesystem firesystem) {
        this.firesystem = firesystem;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firesystemId=" + firesystemId +
                ", note='" + note + '\'' +
                ", img='" + img + '\'' +
                ", firesystem=" + firesystem +
                '}';
    }
}
package com.ifood.domain.model;

public class RelatedDish {
    private String id;
    private String name;
    private String imageLink;

    public RelatedDish() {
    }

    public RelatedDish(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.imageLink = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}

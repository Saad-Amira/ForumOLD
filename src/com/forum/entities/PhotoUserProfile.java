package com.forum.entities;
// Generated 25 fevr. 2015 16:41:06 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PhotoUserProfile generated by hbm2java
 */
@Entity
@Table(name="photo_user_profile"
    ,catalog="forum_db"
)
public class PhotoUserProfile  implements java.io.Serializable {


     private Integer idPhotoUserProfile;
     private User user;
     private byte[] photo;
     private String lastone;

    public PhotoUserProfile() {
    }

    public PhotoUserProfile(User user, byte[] photo, String lastone) {
       this.user = user;
       this.photo = photo;
       this.lastone = lastone;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_photo_user_profile", unique=true, nullable=false)
    public Integer getIdPhotoUserProfile() {
        return this.idPhotoUserProfile;
    }
    
    public void setIdPhotoUserProfile(Integer idPhotoUserProfile) {
        this.idPhotoUserProfile = idPhotoUserProfile;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_user", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="photo", nullable=false)
    public byte[] getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    
    @Column(name="lastone", nullable=false, length=10)
    public String getLastone() {
        return this.lastone;
    }
    
    public void setLastone(String lastone) {
        this.lastone = lastone;
    }




}



package com.runtimeterror.saac.model.def;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "facebook_id", length = 1024, nullable = true)
    private String facebookId;

    @Column(name = "country", length = 32, nullable = false)
    private String country;

    @Column(name = "email", length = 64, nullable = false)
    private String email;

    @Column(name = "signup_type", length = 16, nullable = false)
    private String singupType;

    @Column(name = "recruter_id", nullable = true)
    private Integer recruterId;

    @Column(name = "gender", length = 1, nullable = false)
    private String gender;

    @Column(name = "postal_code", length = 8, nullable = false)
    private String postalCode;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number", length = 64, nullable = true)
    private String phoneNumber;

    @Column(name = "status", length = 16, nullable = false)
    private String status;

    @Column(name = "current_balance", nullable = true)
    private Float currentBalance;

    @Column(name = "email_notiication_type", nullable = false)
    private String emailNotificationType;

    @Column(name = "selected_hour", nullable = true)
    private Integer selectedHour;

    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSingupType() {
        return singupType;
    }

    public void setSingupType(String singupType) {
        this.singupType = singupType;
    }

    public Integer getRecruterId() {
        return recruterId;
    }

    public void setRecruterId(Integer recruterId) {
        this.recruterId = recruterId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getEmailNotificationType() {
        return emailNotificationType;
    }

    public void setEmailNotificationType(String emailNotificationType) {
        this.emailNotificationType = emailNotificationType;
    }

    public Integer getSelectedHour() {
        return selectedHour;
    }

    public void setSelectedHour(Integer selectedHour) {
        this.selectedHour = selectedHour;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", facebookId='" + facebookId + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", singupType='" + singupType + '\'' +
                ", recruterId=" + recruterId +
                ", gender='" + gender + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                ", currentBalance=" + currentBalance +
                ", emailNotificationType='" + emailNotificationType + '\'' +
                ", selectedHour=" + selectedHour +
                ", createdAt=" + createdAt +
                '}';
    }
}

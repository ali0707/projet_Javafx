package Entities;

import java.sql.Timestamp;
import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String usernameCanonical;
    private String email;
    private String emailCanonical;
    private boolean enabled;
    private String salt;
    private String password;
    private Timestamp lastLogin;
    private String confirmationToken;
    private Timestamp passwordRequestedAt;
    private String roles;
    private Integer infosId;
    private Integer authCode;

    public User(int id, String username, String usernameCanonical, String email, String emailCanonical, boolean enabled, String salt, String password, Timestamp lastLogin, String confirmationToken, Timestamp passwordRequestedAt, String roles, Integer infosId, Integer authCode) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.passwordRequestedAt = passwordRequestedAt;
        this.roles = roles;
        this.infosId = infosId;
        this.authCode = authCode;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }


    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }


    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }


    public Timestamp getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Timestamp passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


    public Integer getInfosId() {
        return infosId;
    }

    public void setInfosId(Integer infosId) {
        this.infosId = infosId;
    }


    public Integer getAuthCode() {
        return authCode;
    }

    public void setAuthCode(Integer authCode) {
        this.authCode = authCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                enabled == that.enabled &&
                Objects.equals(username, that.username) &&
                Objects.equals(usernameCanonical, that.usernameCanonical) &&
                Objects.equals(email, that.email) &&
                Objects.equals(emailCanonical, that.emailCanonical) &&
                Objects.equals(salt, that.salt) &&
                Objects.equals(password, that.password) &&
                Objects.equals(lastLogin, that.lastLogin) &&
                Objects.equals(confirmationToken, that.confirmationToken) &&
                Objects.equals(passwordRequestedAt, that.passwordRequestedAt) &&
                Objects.equals(roles, that.roles) &&
                Objects.equals(infosId, that.infosId) &&
                Objects.equals(authCode, that.authCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, usernameCanonical, email, emailCanonical, enabled, salt, password, lastLogin, confirmationToken, passwordRequestedAt, roles, infosId, authCode);
    }

    public boolean hasRole(String role){
        return this.roles.indexOf(role, 0) != -1;
    }
}

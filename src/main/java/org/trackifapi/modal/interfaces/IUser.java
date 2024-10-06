package org.trackifapi.modal.interfaces;

/**
 * Interface para Usuario
 */
public interface IUser {
    String getName();
    String getRg();
    String getCpf();
    int getAge();
    String getEmail();
    String getPhone();
    java.util.Date getDateBirth();
    String getGender();

    void setName(String name);
    void setRg(String rg);
    void setCpf(String cpf);
    void setAge(int age);
    void setEmail(String email);
    void setPhone(String phone);
    void setDateBirth(java.util.Date dateBirth);
    void setGender(String gender);
}

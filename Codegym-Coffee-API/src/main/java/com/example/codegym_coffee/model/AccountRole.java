package com.example.codegym_coffee.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "account_role")
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_account_role")
    private Integer idAccountRole;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public AccountRole() {
    }

    public AccountRole(Integer idAccountRole, Account account, Role role) {
        this.idAccountRole = idAccountRole;
        this.account = account;
        this.role = role;
    }

    public Integer getIdAccountRole() {
        return idAccountRole;
    }

    public void setIdAccountRole(Integer idAccountRole) {
        this.idAccountRole = idAccountRole;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

package neilyich.bsbdkp.model.entity;

import lombok.Data;
import neilyich.bsbdkp.model.AccountRole;
import neilyich.bsbdkp.model.AccountType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(name = "account_role")
    @Enumerated(EnumType.STRING)
    private AccountRole accountRole;
    @Column(name = "reference_id")
    private Integer referenceId;
}

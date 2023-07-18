package com.devmountain.RadRecipeMaker.dtos;

import com.devmountain.RadRecipeMaker.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Set<CommentDto> commentSet = new HashSet<>();


    public UserDto(User user){
        if (user.getId() != null){
            this.id = user.getId();
        }
        if(user.getUsername() != null){
            this.username = user.getUsername();
            System.out.println((username + " :Username"));
        }
        if(user.getPassword() != null){
            this.password = user.getPassword();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<CommentDto> getCommentDtoSet() {
        return commentSet;
    }

    public void setCommentDtoSet(Set<CommentDto> commentDtoSet) {
        this.commentSet = commentDtoSet;
    }
}

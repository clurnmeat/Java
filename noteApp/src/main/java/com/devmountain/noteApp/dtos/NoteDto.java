package com.devmountain.noteApp.dtos;

import com.devmountain.noteApp.entities.Data;
import com.devmountain.noteApp.entities.Note;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto implements Serializable {
    private Long id;
    private String body;
    private UserDto userDto;

    public NoteDto(Note note) {
        if(note.getId() != null) {
            this.id = note.getId();
        }

        if(note.getBody() != null){
            this.body = note.getBody();
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}

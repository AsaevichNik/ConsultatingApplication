package org.tinkoff.mapper.mentor;

import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.Mentor;
import org.tinkoff.dto.mentor.MentorCreateEditDto;
import org.tinkoff.mapper.Mapper;

@Component
public class MentorCreateEditMapper implements Mapper<MentorCreateEditDto, Mentor> {

    @Override
    public Mentor map(MentorCreateEditDto object) {
        Mentor mentor = new Mentor();
        copy(object, mentor);
        return mentor;
    }

    @Override
    public Mentor map(MentorCreateEditDto fromObject, Mentor toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    public void copy(MentorCreateEditDto object, Mentor user) {
        user.setExperience(object.getSkills());
        user.setUserId(object.getUserId());
        user.setSkills(object.getSkills());
        user.setTagId(object.getTagId());
        user.setHowCan_I_Help(object.getHowCan_I_Help());
    }
}
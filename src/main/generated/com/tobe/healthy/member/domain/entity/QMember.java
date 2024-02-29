package com.tobe.healthy.member.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1446485669L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final com.tobe.healthy.common.QBaseTimeEntity _super = new com.tobe.healthy.common.QBaseTimeEntity(this);

    public final ListPath<com.tobe.healthy.schedule.domain.entity.Schedule, com.tobe.healthy.schedule.domain.entity.QSchedule> applicantSchedules = this.<com.tobe.healthy.schedule.domain.entity.Schedule, com.tobe.healthy.schedule.domain.entity.QSchedule>createList("applicantSchedules", com.tobe.healthy.schedule.domain.entity.Schedule.class, com.tobe.healthy.schedule.domain.entity.QSchedule.class, PathInits.DIRECT2);

    public final EnumPath<MemberCategory> category = createEnum("category", MemberCategory.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final QGym gym;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Alarm> isAlarm = createEnum("isAlarm", Alarm.class);

    public final StringPath mobileNum = createString("mobileNum");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final com.tobe.healthy.file.domain.entity.QProfile profileId;

    public final com.tobe.healthy.schedule.domain.entity.QStandBySchedule standBySchedule;

    public final ListPath<com.tobe.healthy.schedule.domain.entity.Schedule, com.tobe.healthy.schedule.domain.entity.QSchedule> trainerSchedules = this.<com.tobe.healthy.schedule.domain.entity.Schedule, com.tobe.healthy.schedule.domain.entity.QSchedule>createList("trainerSchedules", com.tobe.healthy.schedule.domain.entity.Schedule.class, com.tobe.healthy.schedule.domain.entity.QSchedule.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gym = inits.isInitialized("gym") ? new QGym(forProperty("gym"), inits.get("gym")) : null;
        this.profileId = inits.isInitialized("profileId") ? new com.tobe.healthy.file.domain.entity.QProfile(forProperty("profileId"), inits.get("profileId")) : null;
        this.standBySchedule = inits.isInitialized("standBySchedule") ? new com.tobe.healthy.schedule.domain.entity.QStandBySchedule(forProperty("standBySchedule"), inits.get("standBySchedule")) : null;
    }

}


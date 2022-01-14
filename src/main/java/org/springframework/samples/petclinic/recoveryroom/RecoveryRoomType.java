package org.springframework.samples.petclinic.recoveryroom;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

@Getter
@Setter
@Entity
@Table(name="recovery_room_type")
public class RecoveryRoomType extends BaseEntity {
	@NotBlank
	@Size(min=5, max=50)
	@Column(unique = true)
    String name;
}

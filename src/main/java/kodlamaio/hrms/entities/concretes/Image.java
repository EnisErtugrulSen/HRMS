package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "url")
	private String url;

	@JsonIgnore
	@Column(name = "created_date",nullable = true)
	private LocalDate createdDate = LocalDate.now();

	@JsonIgnore
	@Column(name = "is_active")
	private boolean isActive;

	@JsonIgnore
	@Column(name = "is_deleted")
	private boolean isDeleted;

	@OneToOne()
    @JoinColumn(name = "job_seeker_id",referencedColumnName="user_id")
	//@JsonIgnore
    private JobSeeker jobSeeker;
}

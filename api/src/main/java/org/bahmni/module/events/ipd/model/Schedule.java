package org.bahmni.module.events.ipd.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Concept;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "ipd_schedule")
public class Schedule extends BaseOpenmrsMetadata {
	
	// Based on https://hl7.org/fhir/R4/schedule.html v4.0.1
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "schedule_id")
	private Integer id;
	
	/**
	 * The entity who benefits from the performance of the service specified in the task (e.g., the
	 * patient).
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "for_reference_id", referencedColumnName = "reference_id")
	private Reference forReference;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "by_reference_id", referencedColumnName = "reference_id")
	private Reference byReference;
	
	/**
	 * The location Where schedule occurs
	 */
	/*@ManyToOne(optional = false)
	@JoinColumn(name = "location_id", referencedColumnName = "location_id")
	private Location locationId;*/
	
	/**
	 * Whether this schedule is in active use
	 */
	@Column(name = "active", nullable = false)
	private boolean active = Boolean.TRUE;
	
	/**
	 * The Service Category of the Schedule
	 */
	@OneToOne
	@JoinColumn(name = "service_category_id", referencedColumnName = "concept_id")
	private Concept serviceCategoryId;
	
	/**
	 * The Service Type of the Schedule
	 */
	@OneToOne
	@JoinColumn(name = "service_type_id", referencedColumnName = "concept_id")
	private Concept serviceType;
	
	/**
	 * The Speciality of the Schedule
	 */
	@OneToOne
	@JoinColumn(name = "speciality_id", referencedColumnName = "concept_id")
	private Concept speciality;
	
	/**
	 * The Start Date the Schedule
	 */
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	/**
	 * The End Date the Schedule
	 */
	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	/**
	 * Any Comment for the Schedule
	 */
	@Column(name = "comments")
	private String comments;
	
}

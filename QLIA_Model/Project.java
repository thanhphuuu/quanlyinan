package QLIA_Model;

import java.time.LocalDateTime;
import java.util.Set;

import QLIA_Enum.ProjectStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "request_description_from_customer")
    private String requestDescriptionFromCustomer;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "expected_end_date")
    private LocalDateTime expectedEndDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_status")
    private ProjectStatus projectStatus;

    @OneToMany(mappedBy = "project")
    private Set<Bill> bills;

    @OneToMany(mappedBy = "project")
    private Set<Design> designs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRequestDescriptionFromCustomer() {
		return requestDescriptionFromCustomer;
	}

	public void setRequestDescriptionFromCustomer(String requestDescriptionFromCustomer) {
		this.requestDescriptionFromCustomer = requestDescriptionFromCustomer;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getExpectedEndDate() {
		return expectedEndDate;
	}

	public void setExpectedEndDate(LocalDateTime expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	public Set<Design> getDesigns() {
		return designs;
	}

	public void setDesigns(Set<Design> designs) {
		this.designs = designs;
	}

    
}

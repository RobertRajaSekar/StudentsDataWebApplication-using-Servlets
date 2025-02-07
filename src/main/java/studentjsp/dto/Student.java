package studentjsp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Student {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String email;
		private String password;
		private String address;
		private long phone;
		private String course;
		private Double fees;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getCourse() {
			return course;
		}
		public void setCourse(String course) {
			this.course = course;
		}
		public Double getFees() {
			return fees;
		}
		public void setFees(Double fees) {
			this.fees = fees;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
					+ address + ", phone=" + phone + ", course=" + course + ", fees=" + fees + "]";
		}
		
}

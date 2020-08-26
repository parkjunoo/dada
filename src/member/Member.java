package member;

import java.net.PasswordAuthentication;
import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Member 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private String id; // 사용자 아이디
	
	@NotEmpty
	private String name; // 이름
	
	@NotEmpty
	private String password; // 비밀번호
	
	@NotEmpty
	private String classCode; // 수강중인 수업
	
	@Column(name = "JOIN_DATE") // DB의 JOIN_DATE에 매핑함
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate joinDate; // 회원가입일자
	
	// 생성자
	public Member(@NotEmpty String name, @NotEmpty String password, @NotEmpty String classCode)
	{
		this.name = name;
		this.classCode = classCode;
		this.password = password;
		this.joinDate = LocalDate.now();
	}
}
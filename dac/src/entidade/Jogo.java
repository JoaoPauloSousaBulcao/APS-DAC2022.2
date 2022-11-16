package entidade;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="jogo")
public class Jogo {
	
	
		@Id
		@Column
		@GeneratedValue
		private Integer id;
		private Integer v1;
		private Integer v2;
		private Integer v3;
		private Integer v4;
		private Integer v5;
		private Integer maior;
		@Temporal(TemporalType.TIMESTAMP)
		private Date dataJogo = new Date();
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getV1() {
			return v1;
		}
		public void setV1(Integer v1) {
			this.v1 = v1;
		}
		public Integer getV2() {
			return v2;
		}
		public void setV2(Integer v2) {
			this.v2 = v2;
		}
		public Integer getV3() {
			return v3;
		}
		public void setV3(Integer v3) {
			this.v3 = v3;
		}
		public Integer getV4() {
			return v4;
		}
		public void setV4(Integer v4) {
			this.v4 = v4;
		}
		public Integer getV5() {
			return v5;
		}
		public void setV5(Integer v5) {
			this.v5 = v5;
		}
		public Integer getMaior() {
			return maior;
		}
		public void setMaior() {
			
			maior = v1;
			
			if(maior < v2) {
				maior =v2;
			}
			
			if(maior < v3) {
				maior = v3;
			}
			
			if(maior < v4) {
				maior = v4;
			}
			if(maior < v5) {
				maior = v5;
			}
			
		

		}
		public Date getDataJogo() {
			return dataJogo;
		}
		public void setDataJogo(Date dataJogo) {
			this.dataJogo = dataJogo;
		}
		
		
		
		
		
		

}

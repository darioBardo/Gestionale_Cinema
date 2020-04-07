package it.fides.cinema.enumeration;

public enum RoleEnum {
	
	ADMIN("admin"),
	UTENTE("utente");
	
	private String role;
	
	RoleEnum(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
	
}


 REST Service version of MemberMVC from Lesson 11...
 
 Uses Spring MVC Controller for REST services.
 The client side is a separate project: 
 
 MemberMVC[Lesson 12]  
           OR 
 MemberMVCCloud[Lesson 13]  
 
 NOTE: JSON circular dependencies are necessary to resolve...
 UserCredentials has  	@JsonManagedReference on Member relationship
  and 
  Member has @	@JsonBackReference  on UserCredentials
  
see   http://wiki.fasterxml.com/JacksonFeatureBiDirReferences
  
  Member has @JsonIgnore on Addresses
 
 
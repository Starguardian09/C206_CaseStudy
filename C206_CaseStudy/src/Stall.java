import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Isaac Tan
 * Student ID: 21021646
 * Class: C208-2S4S-W64L
 * Date/Time created: Monday 08-08-2022 15:32
 */

/**
 * @author 21021646
 *
 */
public class Stall {
	  private int stallId;
	  private String stallName;

	  public Stall(int stallId, String stallName) {
	    super();
	    this.stallId = stallId;
	    this.stallName = stallName;
	  }

	  public int getStallId() {
	    return stallId;
	  }

	  public void setStallId(int stallId) {
	    this.stallId = stallId;
	  }

	  public String getStallName() {
	    return stallName;
	  }

	  public void setStallName(String stallName) {
	    this.stallName = stallName;
	  }

	}
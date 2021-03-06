/**
 * 
 */
package info.beans;

/**
 * @author fabien
 *
 */
public class DetailBook extends Book {

	private String resume;
	
	private boolean isStocked;
	
	private String quantityToCommand;
	
	private String imgName;


	public DetailBook(String title, String price, Author author, String id, String resume, boolean isStocked,
			String quantityToCommand, String imgName) {
		super(title, price, author, id);
		this.resume = resume;
		this.isStocked = isStocked;
		this.quantityToCommand = quantityToCommand;
		this.imgName = imgName;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public boolean isStocked() {
		return isStocked;
	}

	public void setStocked(boolean isStocked) {
		this.isStocked = isStocked;
	}

	public String getQuantityToCommand() {
		return quantityToCommand;
	}

	public void setQuantityToCommand(String quantityToCommand) {
		this.quantityToCommand = quantityToCommand;
	}


}

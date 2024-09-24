package Pratica;

public class VetorObjetos {

	private Object[] elementos; 
	private int tamanho;

	public VetorObjetos(int capacidade){
		this.elementos = new Object[capacidade];
		this.tamanho = 0;
	}

	public boolean adiciona(Object elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.elementos.length){
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		} 
		return false;
	}
	
	public boolean adiciona(int posicao, Object elemento){	
		if (!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição inválida");
		}
		this.aumentaCapacidade();
		//mover todos os elementos
		for (int i=this.tamanho-1; i>=posicao; i--){
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;
		return true;
	}
	
	private void aumentaCapacidade(){
		if (this.tamanho == this.elementos.length){
			Object[] elementosNovos = new Object[this.elementos.length * 2];
			for (int i=0; i<this.elementos.length; i++){
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	
	public Object busca(int posicao){
		if (!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição inválida");
		} 
		return this.elementos[posicao];
	}
	
	public int busca(Object elemento){
		for (int i=0; i<this.tamanho; i++){
			if (this.elementos[i].equals(elemento)){
				return i;
			}
		}
		return -1;
	}
	
	public void remove(int posicao){
		if (!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i=posicao; i<this.tamanho-1; i++){
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}
	
	public int tamanho(){
		return this.tamanho;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[\n");
		for (int i=0; i<this.tamanho-1; i++){
			s.append(this.elementos[i]);
		}
		if (this.tamanho>0){
			s.append(this.elementos[this.tamanho-1]);
		}
		s.append("\n]");
		return s.toString();
	}

	public int capacidade() {
		return this.elementos.length;
	}

	// Método Bubble Sort para ordenar os elementos
    public void ordena() {
        boolean flag = false;
		for (int i = 0; i < this.tamanho - 1; i++) {
            flag = false;
			for (int j = 0; j < this.tamanho - 1 - i; j++) {
                // Verifica se os elementos são comparáveis
                if (!(this.elementos[j] instanceof Comparable) || !(this.elementos[j + 1] instanceof Comparable))
					throw new IllegalArgumentException("Elementos não comparáveis.");

				Comparable obj1 = (Comparable) this.elementos[j];
				Comparable obj2 = (Comparable) this.elementos[j + 1];

				// Compara e troca se necessário
				if (obj1.compareTo(obj2) > 0) {
					Object temp = this.elementos[j];
					this.elementos[j] = this.elementos[j + 1];
					this.elementos[j + 1] = temp;
					flag = true;
				}
            }
			if (!flag) break;
        }
    }

}
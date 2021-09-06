export class Paginador {
    registros = 0;
    currentPage = 1;
    numberPerPage = 20;
    numberOfPages = 1;
    begin = 0;
    end = 0;
    label = '0 - 0 de 0';
    public setlist(list: number, page = 0) {
        if (page > 0) {
            this.numberPerPage = page;
        }
        this.registros = list;
        this.numberOfPages = Math.ceil(this.registros / this.numberPerPage);
        this.loadList();
    }
    nextPage() {
        this.currentPage += 1;
        if (this.currentPage > this.numberOfPages) {
            this.currentPage = 1;
        }
        this.loadList();
    }
    previousPage() {
        this.currentPage -= 1;
        if (this.currentPage <= 0) {
            this.currentPage = this.numberOfPages;
        }
        this.loadList();
    }
    firstPage() {
        this.currentPage = 1;
        this.loadList();
    }
    lastPage() {
        this.currentPage = this.numberOfPages;
        this.loadList();
    }
    loadList() {
        if (this.registros > 0) {
            this.begin = ((this.currentPage - 1) * this.numberPerPage);
            this.end = this.begin + this.numberPerPage;
            if (this.end > this.registros) {
                this.end = this.registros;
            }
            this.label = `${this.begin + 1} - ${this.end} de ${this.registros}`;
        }
    }
    paginar(idx: number) {
        return idx >= this.begin && idx < this.end;
    }
    filterByValue(array: any, string: string) {
        return array.filter((o: any) =>
            Object.keys(o).some(k => String(o[k]).toLowerCase().includes(string.toLowerCase())));
    }
}

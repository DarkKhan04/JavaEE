<form action="add-book" method="post">
    <div class="row">
        <div class="col-12">
            <label>NAME : </label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <input type="text" class="form-control" name="book_name">
        </div>
    </div>

    <div class="row mt-3">
        <div class="col-12">
            <label>AUTHOR : </label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <input type="text" class="form-control" name="book_author">
        </div>
    </div>

    <div class="row mt-3" >
        <div class="col-12">
            <label>GENRE : </label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12" >
            <select class="form-select" name="book_genre">
                <option>FANTASY</option>
                <option>HORROR</option>
                <option>DRAMA</option>
                <option>ROMAN</option>
                <option>BIOGRAPHY</option>
            </select>
        </div>
    </div>

    <div class="row mt-3">
        <div class="col-12">
            <label>PRICE : </label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <input type="number" class="form-control" name="book_price">
        </div>
    </div>

    <div class="row mt-3">
        <div class="col-12">
            <label>DESCRIPTION : </label>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <textarea class="form-control" name="description"></textarea>
        </div>
    </div>

    <div class="row mt-3">
        <div class="col-12">
            <button class="btn btn-success">ADD BOOK</button>
        </div>
    </div>
</form>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sahudyscos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</head>
<body>
    <header>
        <nav class="navbar justify-content-center navbar-expand-lg navbar-dark bg-dark">
              
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <a class="navbar-brand justify-content-start" href="index.html"><img src="logo/logo.png" alt=""></a>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item-active">
                       
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item my-2">
                        <a class="nav-link" href="signup.html">Registrar</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.html"><button class="btn btn-success">Login</button></a>
                    </li>
                </ul>
            </div>

            <button class="navbar-toggler justify-content-end" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>
    </header>

    <div class="container-fluid">
    <div id="advertisement" class="carousel slide" data-ride="carousel">
         <ul class="carousel-indicators">
            <li data-target="#advertisement" data-slide-to="0" class="active"></li>
            <li data-target="#advertisement" data-slide-to="1"></li>
            <li data-target="#advertisement" data-slide-to="2"></li>
        </ul>

        <div class="carousel-inner" style="background-color: black">
            <div class="carousel-item active">
                <img src="banner/1.png" class="d-block mx-auto" alt="São legais mesmo">
            </div>
            <div class="carousel-item">
                <img src="banner/2.png" class="d-block mx-auto" alt="Vai por mim">
            </div>
            <div class="carousel-item">
                <img src="banner/3.png" class="d-block mx-auto" alt="Pode confiar">
            </div>
        </div>
        
            <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#advertisement" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#advertisement" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
    </div>

    <main>
        <div class="container-fluid">
        <div class="row">
        <aside class="col-sm-12 col-md-2 py-3">
            <nav>
                <ul class="nav flex-column">
                    <li class="nav-item py-3">
                        <h4 class="text-center">Gênero</h4>
                        <div class="list-group list-group-flush">
                            <a href="#" class="list-group-item list-group-item-action">Rock</a>
                            <a href="#" class="list-group-item list-group-item-action">Eletrônica</a>
                            <a href="#" class="list-group-item list-group-item-action">Pop</a>
                            <a href="#" class="list-group-item list-group-item-action">Jazz</a>
                            <a href="#" class="list-group-item list-group-item-action list-group-item-info">Todos<a>
                        </div>
                    </li>
                    <li class="nav-item py-3">
                        <h4 class="text-center">Formato</h4>
                        <div class="list-group list-group-flush">
                                <a href="#" class="list-group-item list-group-item-action">CD</a>
                                <a href="#" class="list-group-item list-group-item-action">Vinil</a>
                                <a href="#" class="list-group-item list-group-item-action">Cassete</a>
                                <a href="#" class="list-group-item list-group-item-action">VHS</a>
                                <a href="#" class="list-group-item list-group-item-action list-group-item-info">Todos<a>
                            </div>
                    </li>
                    <li class="nav-item py-3">
                        <h4 class="text-center">País</h4>
                        <div class="list-group list-group-flush">
                                <a href="#" class="list-group-item list-group-item-action">EUA</a>
                                <a href="#" class="list-group-item list-group-item-action">Reino Unido</a>
                                <a href="#" class="list-group-item list-group-item-action">Brasil</a>
                                <a href="#" class="list-group-item list-group-item-action">França</a>
                                <a href="#" class="list-group-item list-group-item-action list-group-item-info">Todos<a>
                        </div>
                    </li>
                    <li class="nav-item py-3">
                        <h4 class="text-center">Década</h4>
                        <div class="list-group list-group-flush">
                                <a href="#" class="list-group-item list-group-item-action">2010</a>
                                <a href="#" class="list-group-item list-group-item-action">2000</a>
                                <a href="#" class="list-group-item list-group-item-action">1990</a>
                                <a href="#" class="list-group-item list-group-item-action">1980</a>
                                <a href="#" class="list-group-item list-group-item-action list-group-item-info">Todos<a>
                        </div>
                    </li>
                    <li class="nav-item py-3">
                        <h4 class="text-center">Avaliação</h4>
                        <div class="list-group list-group-flush">
                                <a href="#" class="list-group-item list-group-item-action">Acima de 4,0</a>
                                <a href="#" class="list-group-item list-group-item-action">Acima de 3,0</a>
                                <a href="#" class="list-group-item list-group-item-action">Acima de 2,0</a>
                                <a href="#" class="list-group-item list-group-item-action">Acima de 1,0</a>
                                <a href="#" class="list-group-item list-group-item-action list-group-item-info">Todos<a>
                        </div>
                    </li>
                </ul>
            </nav>
        </aside>

        <section class="col-sm-12 col-md-10 py-3">
            <ul class="nav nav-tabs" id="main-tabs">
                    <li class="nav-item">
                        <a class="nav-link active" id="all-tab" data-toggle="tab" href="#all" role="tab" aria-controls="all" aria-selected="true">Tudo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="albums-tab" data-toggle="tab" href="#albums" role="tab" aria-controls="albums" aria-selected="false">Álbuns</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="releases-tab" data-toggle="tab" href="#releases" role="tab" aria-controls="releases" aria-selected="false">Versões</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="labels-tab" data-toggle="tab" href="#labels" role="tab" aria-controls="labels" aria-selected="false">Gravadoras</a>
                    </li>
                    <li>
                         <form class="form-inline my-2 my-md-0">
                            <div class="input-group">
                                <input class="form-control" type="search" placeholder="Pesquisar" aria-label="Search" aria-describedby="basic-addon1">
                                <div class="input-group-append">
                                    <select class="custom-select" id="sel1"> <!-- Podemos tirar isso mas vai ficar difícil pra caramba de fazer consulta -->
                                        <option>Banda</option>
                                        <option>Álbum</option>
                                        <option>Versão</option>
                                        <option>Gravadora</option>
                                        <option>País</option>
                                    </select>
                                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
                                </div>
                                
                            </div>
                        </form>
                    </li>
            </ul>
    
                <div class="tab-content" id="main-tabs"> <!-- Posteriormentes essas tabs serão dinâmicas de verdade, jQuery talvez? -->
                    <div class="tab-pane fade show active" id="all" role="tabpanel" aria-labelledby="all-tab">
                        <div class="row col-md-11">
                            <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                    <a href="release.html"><img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap"></a>
                                    <div class="card-body">
                                        <h5 class="card-title"><a href="artist.html">Wesley Safadão</a></h5>
                                        <p class="card-text"><a href="release.html">Duetos</a> <button class="btn btn-sm btn-outline-success float-right ">R$90,00</button></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                    <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674411-1484570978-1942.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Wesley Safadão</h5>
                                        <p class="card-text">WS Em Casa</p>
                                    </div>
                                </div>
                            </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                    <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4746.jpeg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Wesley Safadão</h5>
                                        <p class="card-text">Paradise</p>
                                    </div>
                                </div>
                            </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                    <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4748.jpeg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Wesley Safadão</h5>
                                        <p class="card-text">Paradise</p>
                                    </div>
                                </div>
                            </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                    <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4750.jpeg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Wesley Safadão</h5>
                                        <p class="card-text">Uma Nova História</p>
                                    </div>
                                </div>
                            </div>
                        
                       
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4752.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Metallica</h5>
                                            <p class="card-text">Master of Puppets</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4754.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Metallica</h5>
                                            <p class="card-text">Hardwired</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4756.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Rainbow</h5>
                                            <p class="card-text">Rising</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                           
                         
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                            
                         
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                </div>
                            </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                        <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">Wesley</p>
                                        </div>
                                    </div>
                                </div>
                           <div class="col-xs-4 col-sm-4 col-md-3 my-1">
                                <div class="card showbox">
                                    <img class="card-img-top img-thumbnail" src="<?php echo base_url('images/') ?>cover/R-9674533-1484572870-4744.jpeg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">Wesley</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="text-center my-5">
                            <button class="btn btn-success">Ver mais</button>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="albums" role="tabpanel" aria-labelledby="albums-tab"></div>
                    <div class="tab-pane fade" id="releases" role="tabpanel" aria-labelledby="releases-tab"></div>
                    <div class="tab-pane fade" id="labels" role="tabpanel" aria-labelledby="labels-tab"></div>
                </div>
        </section> 
        </div>
    </div>
    </main>

    <!--Footer-->
    <footer class="page-footer font-small blue pt-4 mt-4 bg-dark">

        <!--Copyright-->
        <div class="footer-copyright text-center">
            © 2018 Copyright: Sahudyscos
        </div>
        <!--/.Copyright-->

    </footer>
    <!--/.Footer-->
</body>
</html>

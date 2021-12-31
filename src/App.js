import { useState } from 'react';
import './App.css';
import html2canvas from 'html2canvas';


const App = () =>{
  
  // Creamos un Estados de React
  const [line1, setLine1] = useState('');
  const [line2, setLine2] = useState('');
  const [image, setImage] = useState('');
  // Subrutinas para cambiar los valores de las lineas
  const changeLine1 = line =>{
    setLine1(line.target.value);
  }
  
  const changeLine2 = line =>{
    setLine2(line.target.value);
  }
  
  // Subrutina para traer los valores de la imagen
  const changeImage = image => {
    setImage(image.target.value);
  }

  // Subrutina para crear el meme
  const createMeme = meme =>{
    html2canvas(document.querySelector("#meme")).then(canvas => {
      const image = canvas.toDataURL("image/png")
      const link = document.createElement('a');
      link.download = 'meme.png';
      link.href = image;
      link.click();
    });
  }

  return (
    <div className="App">

      <h1>Crear Tu Meme!!!</h1>

      {/* Cajas de Texto para Excribir en la imagen */}
      <input onChange={changeLine1} type="text" placeholder="Escribe la Linea 1"/>
      <br/>

      <input onChange={changeLine2} type="text" placeholder="Escribe la Linea 2"/>
      <br/>

      {/* Select Picker de Memes */}
      <select onChange={changeImage} className='selector-meme'>
        <option value="fire">Casa en LLamas</option>
        <option value="futurama">Futurama</option>
        <option value="history">History Channel</option>
        <option value="matrix">Matrix</option>
        <option value="philosoraptor">Philosoraptor</option>
        <option value="smart">Smart Guy</option>
      </select>
      <br/>

      {/* Span para mostrar la lineas escritas */}
      <div className="meme" id='meme'>
        <span id="line1">{line1}</span>
        <br/>
        <span id="line2">{line2}</span>
        <img src={"/img/"+image+".jpg"}/>
      </div>

      {/*Boton para exportar los memes */}
      <button className='btn' onClick={createMeme} >Crear Meme</button>
      
    </div>
  );
}

export default App;

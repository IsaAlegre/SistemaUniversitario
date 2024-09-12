import axios from "axios";
const API_LINK = "http://localhost:8080/api"
export const obtenerAlumnos = async () => {
  try {
    const response = await axios.get(`${API_LINK}/alumnos/relaciones`)
    return response.data
  } catch (error) {
    console.error("Error: ", error)
  }

}


export const matricularAlumno = async () => {
  try {
    const response = await axios.get(`${API_LINK}/alumnos`)
    return response.data
  } catch (error) {
    console.error("Error: ", error)
  }

}



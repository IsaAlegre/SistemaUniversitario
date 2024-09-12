import axios from 'axios';

const API_LINK = "http://localhost:8080/api";

// Rutas de Materias
export const obtenerTodasLasMaterias = async () => {
  try {
    const response = await axios.get(`${API_LINK}/materias`);
    return response.data;
  } catch (error) {
    console.error("Error al obtener todas las materias:", error);
  }
};

export const obtenerMateriaPorUUID = async (uuid) => {
  try {
    const response = await axios.get(`${API_LINK}/materias/${uuid}`);
    return response.data;
  } catch (error) {
    console.error(`Error al obtener la materia con UUID ${uuid}:`, error);
  }
};

export const crearMateria = async (data) => {
  try {
    const response = await axios.post(`${API_LINK}/materias`, data);
    return response.data;
  } catch (error) {
    console.error("Error al crear materia:", error);
  }
};

export const actualizarMateria = async (uuid, data) => {
  try {
    const response = await axios.put(`${API_LINK}/materias/${uuid}`, data);
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar la materia con UUID ${uuid}:`, error);
  }
};

export const eliminarMateria = async (uuid) => {
  try {
    const response = await axios.delete(`${API_LINK}/materias/${uuid}`);
    return response.data;
  } catch (error) {
    console.error(`Error al eliminar la materia con UUID ${uuid}:`, error);
  }
};

// Rutas de Profesores
export const obtenerTodosLosProfesores = async () => {
  try {
    const response = await axios.get(`${API_LINK}/profesores`);
    return response.data;
  } catch (error) {
    console.error("Error al obtener todos los profesores:", error);
  }
};

export const obtenerProfesorPorDNI = async (dni) => {
  try {
    const response = await axios.get(`${API_LINK}/profesores/${dni}`);
    return response.data;
  } catch (error) {
    console.error(`Error al obtener el profesor con DNI ${dni}:`, error);
  }
};

export const crearProfesor = async (data) => {
  try {
    const response = await axios.post(`${API_LINK}/profesores`, data);
    return response.data;
  } catch (error) {
    console.error("Error al crear profesor:", error);
  }
};

export const actualizarProfesor = async (dni, data) => {
  try {
    const response = await axios.put(`${API_LINK}/profesores/${dni}`, data);
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar el profesor con DNI ${dni}:`, error);
  }
};

export const eliminarProfesor = async (dni) => {
  try {
    const response = await axios.delete(`${API_LINK}/profesores/${dni}`);
    return response.data;
  } catch (error) {
    console.error(`Error al eliminar el profesor con DNI ${dni}:`, error);
  }
};

// Rutas de Alumnos
export const obtenerTodosLosAlumnos = async () => {
  try {
    const response = await axios.get(`${API_LINK}/alumnos`);
    return response.data;
  } catch (error) {
    console.error("Error al obtener todos los alumnos:", error);
  }
};

export const obtenerAlumnoPorDNI = async (dni) => {
  try {
    const response = await axios.get(`${API_LINK}/alumnos/${dni}`);
    return response.data;
  } catch (error) {
    console.error(`Error al obtener el alumno con DNI ${dni}:`, error);
  }
};

export const crearAlumno = async (data) => {
  try {
    const response = await axios.post(`${API_LINK}/alumnos`, data);
    return response.data;
  } catch (error) {
    console.error("Error al crear alumno:", error);
  }
};

export const actualizarAlumno = async (dni, data) => {
  try {
    const response = await axios.put(`${API_LINK}/alumnos/${dni}`, data);
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar el alumno con DNI ${dni}:`, error);
  }
};

export const eliminarAlumno = async (dni) => {
  try {
    const response = await axios.delete(`${API_LINK}/alumnos/${dni}`);
    return response.data;
  } catch (error) {
    console.error(`Error al eliminar el alumno con DNI ${dni}:`, error);
  }
};

// Rutas de Inscripciones (Alumnos - Carreras - Materias)
export const inscribirAlumnoACarrera = async (dni, carreraId) => {
  try {
    const response = await axios.post(`${API_LINK}/alumnos/${dni}/inscribir-carrera/${carreraId}`);
    return response.data;
  } catch (error) {
    console.error(`Error al inscribir el alumno con DNI ${dni} a la carrera:`, error);
  }
};

export const darDeBajaAlumnoDeCarrera = async (dni) => {
  try {
    const response = await axios.delete(`${API_LINK}/alumnos/${dni}/baja-carrera`);
    return response.data;
  } catch (error) {
    console.error(`Error al dar de baja el alumno con DNI ${dni} de la carrera:`, error);
  }
};

export const inscribirAlumnoAMateria = async (dni, materiaId) => {
  try {
    const response = await axios.post(`${API_LINK}/alumnos/${dni}/inscribir-materia/${materiaId}`);
    return response.data;
  } catch (error) {
    console.error(`Error al inscribir el alumno con DNI ${dni} a la materia:`, error);
  }
};

export const darDeBajaAlumnoDeMateria = async (dni, materiaId) => {
  try {
    const response = await axios.delete(`${API_LINK}/alumnos/${dni}/baja-materia/${materiaId}`);
    return response.data;
  } catch (error) {
    console.error(`Error al dar de baja el alumno con DNI ${dni} de la materia:`, error);
  }
};

// Rutas de Estado del Alumno
export const obtenerEstadoDelAlumno = async (uuid) => {
  try {
    const response = await axios.get(`${API_LINK}/estado-alumno/${uuid}`);
    return response.data;
  } catch (error) {
    console.error(`Error al obtener el estado del alumno con UUID ${uuid}:`, error);
  }
};

export const actualizarEstadoDelAlumno = async (uuid, estado, inasistencias) => {
  try {
    const response = await axios.put(`${API_LINK}/estado-alumno/${uuid}`, null, {
      params: { estado, inasistencias }
    });
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar el estado del alumno con UUID ${uuid}:`, error);
  }
};

// Rutas de Relaciones
export const obtenerAlumnosConRelaciones = async () => {
  try {
    const response = await axios.get(`${API_LINK}/alumnos/relaciones`);
    return response.data;
  } catch (error) {
    console.error("Error al obtener alumnos con relaciones:", error);
  }
};

export const obtenerAlumnoConRelacionesPorDNI = async (dni) => {
  try {
    const response = await axios.get(`${API_LINK}/alumnos/relaciones/${dni}`);
    return response.data;
  } catch (error) {
    console.error(`Error al obtener el alumno con DNI ${dni} y sus relaciones:`, error);
  }
};

// Rutas de Carreras
export const obtenerTodasLasCarreras = async () => {
  try {
    const response = await axios.get(`${API_LINK}/carreras`);
    return response.data;
  } catch (error) {
    console.error("Error al obtener todas las carreras:", error);
  }
};

export const obtenerCarreraPorUUID = async (uuid) => {
  try {
    const response = await axios.get(`${API_LINK}/carreras/${uuid}`);
    return response.data;
  } catch (error) {
    console.error(`Error al obtener la carrera con UUID ${uuid}:`, error);
  }
};

export const crearCarrera = async (data) => {
  try {
    const response = await axios.post(`${API_LINK}/carreras`, data);
    return response.data;
  } catch (error) {
    console.error("Error al crear carrera:", error);
  }
};

export const actualizarCarrera = async (uuid, data) => {
  try {
    const response = await axios.put(`${API_LINK}/carreras/${uuid}`, data);
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar la carrera con UUID ${uuid}:`, error);
  }
};

export const eliminarCarrera = async (uuid) => {
  try {
    const response = await axios.delete(`${API_LINK}/carreras/${uuid}`);
    return response.data;
  } catch (error) {
    console.error(`Error al eliminar la carrera con UUID ${uuid}:`, error);
  }
};

// Rutas de Coordinadores
export const obtenerTodosLosCoordinadores = async () => {
  try {
    const response = await axios.get(`${API_LINK}/coordinadores`);
    return response.data;
  } catch (error) {
    console.error("Error al obtener todos los coordinadores:", error);
  }
};

export const obtenerCoordinadorPorUUID = async (uuid) => {
  try {
    const response = await axios.get(`${API_LINK}/coordinadores/${uuid}`);
    return response.data;
  } catch (error) {
    console.error(`Error al obtener el coordinador con UUID ${uuid}:`, error);
  }
};

export const crearCoordinador = async (data) => {
  try {
    const response = await axios.post(`${API_LINK}/coordinadores`, data);
    return response.data;
  } catch (error) {
    console.error("Error al crear coordinador:", error);
  }
};

export const actualizarCoordinador = async (uuid, data) => {
  try {
    const response = await axios.put(`${API_LINK}/coordinadores/${uuid}`, data);
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar el coordinador con UUID ${uuid}:`, error);
  }
};

export const eliminarCoordinador = async (uuid) => {
  try {
    const response = await axios.delete(`${API_LINK}/coordinadores/${uuid}`);
    return response.data;
  } catch (error) {
    console.error(`Error al eliminar el coordinador con UUID ${uuid}:`, error);
  }
};

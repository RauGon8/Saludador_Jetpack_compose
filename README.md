# Saludador Jetpack Compose 🚀

Un proyecto para asentar las bases de la programación declarativa en Android utilizando **Jetpack Compose**

## 🎯 Objetivo
El propósito de este módulo es practicar la gestión del estado y la disposición de elementos básicos de UI. La aplicación permite al usuario introducir su nombre, validar la entrada y recibir un saludo personalizado.

## ✨ Características
- **Estado Persistente**: Uso de `rememberSaveable` para que el texto no se pierda al rotar la pantalla.
- **Validación en Tiempo Real**: El botón se habilita solo si el campo de texto no está vacío (`name.isNotBlank()`).
- **Control de Entrada**: Límite de 20 caracteres con un contador visual integrado en el `supportingText` del `TextField`.
- **Experiencia de Usuario (UX)**: El teclado se oculta automáticamente al procesar el saludo mediante `SoftwareKeyboardController`.
- **UI Reactiva**: La interfaz se recompone automáticamente ante cualquier cambio en las variables de estado.

## 🛠️ Tecnologías utilizadas
- **Kotlin**: Lenguaje principal.
- **Jetpack Compose**: Toolkit moderno para construir UI nativas

## 🚀 Cómo ejecutarlo
1. Clona o copia el código del archivo `MainActivity.kt`.
2. Asegúrate de que el `package` coincida con el nombre de tu proyecto en Android Studio.
3. Haz clic en el botón **Run** (Play verde) para desplegarlo en un emulador o dispositivo físico.

## 🧭 Conceptos clave practicados
- **Recomposición**: Entender cómo Compose actualiza la UI cuando el estado cambia.
- **Layouts**: Uso de `Column` y `Arrangement` para organizar elementos verticalmente.
- **Modifiers**: Personalización de márgenes (`padding`) y tamaños (`fillMaxWidth`).
